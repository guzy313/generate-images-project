package com.my.model;

import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/11/17
 */

public class ControlNet {
    private List<Args> args;

    public ControlNet() {
    }

    public ControlNet(List<Args> args) {
        this.args = args;
    }

    public List<Args> getArgs() {
        return args;
    }

    public void setArgs(List<Args> args) {
        this.args = args;
    }
}