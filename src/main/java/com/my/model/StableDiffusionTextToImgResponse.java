package com.my.model;

import java.io.Serializable;
import java.util.List;


/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/11/17
 */


public class StableDiffusionTextToImgResponse implements Serializable {

    /**
     * 生成的图片结果 base64
     */
    private List<String> images;

    /**
     * 入参和默认值
     */
    private StableDiffusionTextToImg parameters;

    /**
     * 参数的组合字符串
     */
    private String info;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public StableDiffusionTextToImg getParameters() {
        return parameters;
    }

    public void setParameters(StableDiffusionTextToImg parameters) {
        this.parameters = parameters;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}