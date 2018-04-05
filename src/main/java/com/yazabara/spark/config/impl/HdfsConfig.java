package com.yazabara.spark.config.impl;

import com.yazabara.spark.config.WithResources;
import com.yazabara.spark.config.resource.impl.ResourceConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("hdfs")
@Setter
@Getter
@ToString
public class HdfsConfig implements WithResources {

    private String host = "localhost";

    private Integer port = 9000;

    private String path;

    private ResourceConfig resource;

    @Override
    public String getResourcePath() {
        return StringUtils.join("hdfs://", host, ":", port, "/", resource.getPath());
    }
}
