package com.yazabara.spark.config.impl;

import com.yazabara.spark.config.WithResources;
import com.yazabara.spark.config.resource.impl.ResourceConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@ToString
@Configuration
@ConfigurationProperties("file")
public class FileConfig implements WithResources {

    private ResourceConfig resource;

    @Override
    public String getResourcePath() {
        return resource.getPath();
    }
}
