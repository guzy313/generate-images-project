package com.my.model;


/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/11/17
 */

public class OverrideSettings {
    private String sd_model_checkpoint;
    private String sd_vae;


    public OverrideSettings() {
    }

    public OverrideSettings(String sd_model_checkpoint, String sd_vae) {
        this.sd_model_checkpoint = sd_model_checkpoint;
        this.sd_vae = sd_vae;
    }

    public String getSd_model_checkpoint() {
        return sd_model_checkpoint;
    }

    public void setSd_model_checkpoint(String sd_model_checkpoint) {
        this.sd_model_checkpoint = sd_model_checkpoint;
    }
}
