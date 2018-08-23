package com.ralap.bigdata.zk.lock;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @author: ralap
 * @date: created at 2018/8/23 16:41
 */
@Component
@ConfigurationProperties(prefix = "zk")
public class ZKConfig {

    private String hosts = "";

    public String getHosts() {
        return hosts;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }
}
