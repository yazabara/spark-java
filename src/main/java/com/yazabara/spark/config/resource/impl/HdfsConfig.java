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
@ConfigurationProperties("hdfs")
@Setter
@Getter
@ToString
public class HdfsConfig implements ResourceConfig {

    private String host = "localhost";

    private Integer port = 9000;

    private String path;

    private String schema;

    private Map<String, String> options;

    @Override
    public String getFilePath() {
        return StringUtils.join("hdfs://", host, ":", port, "/", path);
    }
}
