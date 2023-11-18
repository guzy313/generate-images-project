package com.my.controller;

import com.my.service.GenerateImagesService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.UUID;

@Controller
@RequestMapping(value = "generateImages/*")
public class GenerateImagesController {
    @Resource
    private GenerateImagesService generateImagesService;

    @RequestMapping("/generateAImage")
    public void generate(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String prompt = request.getParameter("prompt");
        String image = generateImagesService.generateAImage(prompt);//生成图片的文件流字符串
        byte[] imageBytes = Base64.getDecoder().decode(image);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);

        // 设置响应头
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + String.format("./%s.png", UUID.randomUUID().toString().replaceAll("-", "")));

        // 将文件流写入响应输出流
        IOUtils.copy(inputStream, response.getOutputStream());

        // 关闭文件流和响应输出流
        inputStream.close();
        response.getOutputStream().flush();

    }




}
