package com.yazabara.spark.config.impl;

import com.yazabara.spark.config.WithResources;
import com.yazabara.spark.config.resource.Resource;
import com.yazabara.spark.config.resource.impl.ResourceConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties("hdfs")
@Setter
@Getter
@ToString
public class HdfsConfig implements WithResources {

    private String host = "localhost";

    private Integer port = 9000;

    private String path;

    private Map<String, ResourceConfig> resources = new HashMap<>();

    @Override
    public Resource getResource(String name) {
        return resources.get(name);
    }

    @Override
    public String getResourcePath(String name) {
        return StringUtils.join("hdfs://", host, ":", port, "/", resources.get(name).getPath());
    }
}
