package com.yazabara.spark.config.resource.impl;

import com.yazabara.spark.config.resource.ResourceConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Setter
@Getter
@ToString
@Configuration
@ConfigurationProperties("file")
public class FileConfig implements ResourceConfig {

    private String path;

    private String schema;

    private Map<String, String> options;

    @Override
    public String getFilePath() {
        return path;
    }
}
