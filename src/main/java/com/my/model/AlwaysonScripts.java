package com.my.model;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/11/17
 */

/**
 * 参考：https://zhuanlan.zhihu.com/p/624042359
 */
public class AlwaysonScripts {
    private ControlNet controlnet;

    public AlwaysonScripts() {
    }

    public AlwaysonScripts(ControlNet controlnet) {
        this.controlnet = controlnet;
    }

    public ControlNet getControlnet() {
        return controlnet;
    }

    public void setControlnet(ControlNet controlnet) {
        this.controlnet = controlnet;
    }
}