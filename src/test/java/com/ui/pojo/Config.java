package com.ui.pojo;

import java.util.Map;
public class Config {
    private Map<String, Environments> environments;

    public Map<String, Environments> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Map<String, Environments> environments) {
        this.environments = environments;
    }
}

