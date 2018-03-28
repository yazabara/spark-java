package com.yazabara.spark.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "s3-conf")
@ToString
@Getter
@Setter
public class S3Config {

    private String bucket;

    private String key;

    private String secret;

    private String endpoint;
}
