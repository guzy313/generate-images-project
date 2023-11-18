package com.my.model;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/11/17
 */

/**
 * 参考：https://github.com/Mikubill/sd-webui-controlnet/wiki/API#integrating-sdapiv12img
 */
public class Args {
    private boolean enabled;
    /**
     * PreProcessor 例如："module": "lineart_coarse"
     */
    private String module;
    private String model;

    /**
     * defaults to 1
     */
    private double weight = 1.0;
    private String input_image;
    private String mask;

    private int control_mode = 0;

    /**
     * enable pixel-perfect preprocessor. defaults to false
     */
    private boolean pixel_perfect;

    /**
     * whether to compensate low GPU memory with processing time. defaults to false
     */
    private boolean lowvram;
    private int processor_res;
    private int threshold_a;
    private int threshold_b;
    private double guidance_start;
    private double guidance_end = 1.0;
    private int resize_mode;


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getInput_image() {
        return input_image;
    }

    public void setInput_image(String input_image) {
        this.input_image = input_image;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public int getControl_mode() {
        return control_mode;
    }

    public void setControl_mode(int control_mode) {
        this.control_mode = control_mode;
    }

    public boolean isPixel_perfect() {
        return pixel_perfect;
    }

    public void setPixel_perfect(boolean pixel_perfect) {
        this.pixel_perfect = pixel_perfect;
    }

    public boolean isLowvram() {
        return lowvram;
    }

    public void setLowvram(boolean lowvram) {
        this.lowvram = lowvram;
    }

    public int getProcessor_res() {
        return processor_res;
    }

    public void setProcessor_res(int processor_res) {
        this.processor_res = processor_res;
    }

    public int getThreshold_a() {
        return threshold_a;
    }

    public void setThreshold_a(int threshold_a) {
        this.threshold_a = threshold_a;
    }

    public int getThreshold_b() {
        return threshold_b;
    }

    public void setThreshold_b(int threshold_b) {
        this.threshold_b = threshold_b;
    }

    public double getGuidance_start() {
        return guidance_start;
    }

    public void setGuidance_start(double guidance_start) {
        this.guidance_start = guidance_start;
    }

    public double getGuidance_end() {
        return guidance_end;
    }

    public void setGuidance_end(double guidance_end) {
        this.guidance_end = guidance_end;
    }

    public int getResize_mode() {
        return resize_mode;
    }

    public void setResize_mode(int resize_mode) {
        this.resize_mode = resize_mode;
    }
}
