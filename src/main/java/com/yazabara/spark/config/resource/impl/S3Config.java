package com.yazabara.spark.config.resource.impl;

import com.yazabara.spark.config.resource.ResourceConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "s3-conf")
@ToString
@Getter
@Setter
public class S3Config implements ResourceConfig {

    private String bucket;

    private String key;

    private String secret;

    private String endpoint;

    private String path;

    private String schema;

    private Map<String, String> options;

    @Override
    public String getFilePath() {
        return StringUtils.join("s3a://", bucket + "/", path);
    }
}
