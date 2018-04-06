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
@ConfigurationProperties(prefix = "s3-conf")
@ToString
@Getter
@Setter
public class S3Config implements WithResources {

    private String bucket;

    private String key;

    private String secret;

    private String endpoint;

    private Map<String, ResourceConfig> resources = new HashMap<>();

    @Override
    public Resource getResource(String name) {
        return resources.get(name);
    }

    @Override
    public String getResourcePath(String name) {
        return StringUtils.join("s3a://", bucket + "/", resources.get(name).getPath());
    }
}
