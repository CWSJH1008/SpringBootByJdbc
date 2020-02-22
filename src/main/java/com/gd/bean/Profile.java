package com.gd.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2020/1/30.
 */
@ConfigurationProperties(prefix="spring.profile")
@Component
public class Profile {
        private String active;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Profile(String active) {
        this.active = active;
    }

    public Profile() {
    }
}
