package com.my.service;


import com.alibaba.fastjson.JSONObject;
import com.my.constants.StableDiffusionPromptConstants;
import com.my.model.*;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.*;

@Service
public class GenerateImagesService {

    private static final Logger log = LoggerFactory.getLogger(GenerateImagesService.class);
    public static String API_URL = "http://127.0.0.1:7860/sdapi/v1/txt2img";//http://sd.cn/sdapi/v1/txt2img



    public void testSdApi() throws IOException {
        StableDiffusionTextToImg body = getArtisticWordStableDiffusionTextToImg();
        final List<String> images = callSdApi(body);
        for (String image : images) {
            writeBase642ImageFile(image, String.format("./%s.png", UUID.randomUUID().toString().replaceAll("-", "")));
        }
    }

    public String generateAImage() throws Exception{
        StableDiffusionTextToImg body = getArtisticWordStableDiffusionTextToImgWithParams(
                "MoyouArtificial_v1060","girl","",-1,768,512,1,28

        );
        final List<String> images = callSdApi(body);
        if(images.size()>0){
            return images.get(0);
        }
        return null;
    }


    public static void writeBase642ImageFile(String image, String fileName) {
        try (OutputStream outputStream = new FileOutputStream(fileName)) {
            byte[] imageBytes = Base64.getDecoder().decode(image);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            log.info("图片写入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 带参获取图片生成对象
     * 部分内容可自定义
     * @param model
     * @param prompt
     * @param negativePrompt
     * @param seed
     * @param width
     * @param height
     * @param batchSize
     * @param steps
     * @return
     * @throws IOException
     */
    private StableDiffusionTextToImg getArtisticWordStableDiffusionTextToImgWithParams(
            String model,
            String prompt,
            String negativePrompt,
            int seed,
            int width,
            int height,
            int batchSize,
            int steps
    ) throws IOException {
//        final String base64SrcImg = convertImageToBase64("D:\\study\\code\\ddd.png");
        Args args1 = new Args();
        args1.setEnabled(true);
        args1.setControl_mode(0);
        args1.setGuidance_start(0);
        args1.setGuidance_end(0.5);
        args1.setWeight(0.3);
        args1.setPixel_perfect(true);
        args1.setResize_mode(1);
        args1.setModel(StringUtils.isEmpty(model)?"anything-v5-PrtRE.safetensors":model);
        args1.setModule("softedge_pidinet");

        Args args2 = new Args();
        args2.setEnabled(true);
        args2.setControl_mode(0);
        args2.setGuidance_start(0);
        args2.setGuidance_end(0.5);
        args2.setWeight(0.75);
        args2.setPixel_perfect(true);
        args2.setResize_mode(1);
        args2.setModel(StringUtils.isEmpty(model)?"anything-v5-PrtRE.safetensors":model);
        args2.setModule("depth_midas");
//        args2.setInput_image(base64SrcImg);

        String vae = "";//外挂模型//"vae-ft-mse-840000-ema-pruned.safetensors";
        StableDiffusionTextToImg body = new StableDiffusionTextToImg();
        body.setSampler_name("");//采样器名称
        body.setPrompt(prompt);//正向提示词
        body.setNegative_prompt(StringUtils.isEmpty(negativePrompt)?
                StableDiffusionPromptConstants.NEGATIVE_PROMPT_DEFAULT_CHARACTER:negativePrompt);//反向提示词
        body.setSampler_index("DPM++ 2M Karras");//采样器
        /*
        兼顾生成耗时、重现性、图片质量：DPM++ 2M Karras，20-30步；UniPC，20-30步；
        注重质量，且不关心重现性：DPM++SDE Karras，10-15步；DDIM，10-15步；
        注重重现性：不要使用任何ancestral采样器（名字里面带a或SDE）*/
        body.setSeed(seed < -1? -1:seed);
        body.setWidth(width<0?768:width);
        body.setHeight(height<0?512:height);
        body.setRestore_faces(false);
        body.setTiling(false);
        body.setClip_skip(2);
        body.setBatch_size(batchSize<0?1:batchSize);//单次生成的图片数量
        body.setScript_args(new ArrayList<>());
        body.setAlwayson_scripts(new AlwaysonScripts(new ControlNet(Lists.newArrayList(args1, args2))));
        body.setSteps(steps<0?28:steps);
        body.setOverride_settings(new OverrideSettings("chosenMix_chosenMix.ckpt [dd0aacadb6]",vae));
        body.setCfg_scale(7.0);
        return body;
    }



    //默认写死的文生图示例
    private StableDiffusionTextToImg getArtisticWordStableDiffusionTextToImg() throws IOException {
//        final String base64SrcImg = convertImageToBase64("D:\\study\\code\\ddd.png");
        Args args1 = new Args();
        args1.setEnabled(true);
        args1.setControl_mode(0);
        args1.setGuidance_start(0);
        args1.setGuidance_end(0.5);
        args1.setWeight(0.3);
        args1.setPixel_perfect(true);
        args1.setResize_mode(1);
//        args1.setModel("control_v11p_sd15_softedge [a8575a2a]");
        args1.setModel("anything-v5-PrtRE.safetensors");
        args1.setModule("Automatic");//外挂模型 默认Automatic 自动
//        args1.setInput_image(base64SrcImg);

        Args args2 = new Args();
        args2.setEnabled(true);
        args2.setControl_mode(0);
        args2.setGuidance_start(0);
        args2.setGuidance_end(0.5);
        args2.setWeight(0.75);
        args2.setPixel_perfect(true);
        args2.setResize_mode(1);
//        args2.setModel("control_v11f1p_sd15_depth [cfd03158]");
        args2.setModel("anything-v5-PrtRE.safetensors");
        args2.setModule("depth_midas");
//        args2.setInput_image(base64SrcImg);

        String vae = "";//"vae-ft-mse-840000-ema-pruned.safetensors";
        StableDiffusionTextToImg body = new StableDiffusionTextToImg();
        body.setSampler_name("");
//        body.setPrompt("(cake:1.8),( 3D:1.8),( shadow:1.8),(best quality:1.25),( masterpiece:1.25), (ultra high res:1.25), (no human:1.3),<lora:tachi-e:1>,(white background:2)");
//        body.setNegative_prompt("EasyNegative, paintings, sketches, (worst quality:2), (low quality:2), (normal quality:2), lowres, normal quality, ((monochrome)), ((grayscale)), skin spots, acnes, skin blemishes, age spot, glans,extra fingers,fewer fingers,strange fingers,bad hand,backlight, (worst quality, low quality:1.4), watermark, logo, bad anatomy,lace,rabbit,back,");
        body.setPrompt("刻晴");//正向提示词
        body.setNegative_prompt("");//反向提示词
        body.setSampler_index("DPM++ SDE Karras");
        body.setSeed(-1);
        body.setWidth(768);
        body.setHeight(512);
        body.setRestore_faces(false);
        body.setTiling(false);
        body.setClip_skip(2);
        body.setBatch_size(1);//单次生成的图片数量
        body.setScript_args(new ArrayList<>());
        body.setAlwayson_scripts(new AlwaysonScripts(new ControlNet(Lists.newArrayList(args1, args2))));
        body.setSteps(28);
        body.setOverride_settings(new OverrideSettings("chosenMix_chosenMix.ckpt [dd0aacadb6]",vae));
        body.setCfg_scale(7.0);
        return body;
    }

    public static String convertImageToBase64(String imagePath) throws IOException {
        File file = new File(imagePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] imageData = new byte[(int) file.length()];
        fileInputStream.read(imageData);
        fileInputStream.close();
        return Base64.getEncoder().encodeToString(imageData);
    }

    private List<String> callSdApi(StableDiffusionTextToImg body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<StableDiffusionTextToImg> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<JSONObject> entity = restTemplate.postForEntity(API_URL, requestEntity, JSONObject.class);
        final StableDiffusionTextToImgResponse stableDiffusionTextToImgResponse = handleResponse(entity);
        final List<String> images = stableDiffusionTextToImgResponse.getImages();

        if (CollectionUtils.isEmpty(images)) {
            log.info("empty images");
            return Lists.newArrayList();
        }

        return images;
    }


    private StableDiffusionTextToImgResponse handleResponse(ResponseEntity<JSONObject> response) {
        if (Objects.isNull(response) || !response.getStatusCode().is2xxSuccessful()) {
            log.warn("call stable diffusion api status code: {}", JSONObject.toJSONString(response));
        }

        final JSONObject body = response.getBody();
        if (Objects.isNull(body)) {
            log.error("send request failed. response body is empty");
        }
        return body.toJavaObject(StableDiffusionTextToImgResponse.class);
    }

}
