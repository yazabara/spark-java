package com.yazabara.spark.config.impl;

import com.yazabara.spark.config.WithResources;
import com.yazabara.spark.config.resource.Resource;
import com.yazabara.spark.config.resource.impl.ResourceConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@ToString
@Configuration
@ConfigurationProperties("file")
public class FileConfig implements WithResources {

    private Map<String, ResourceConfig> resources = new HashMap<>();

    @Override
    public Resource getResource(String name) {
        return resources.get(name);
    }

    @Override
    public String getResourcePath(String name) {
        return resources.get(name).getPath();
    }
}
