package com.yazabara.spark.config;

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
public class HdfsConfig {

    private String host = "localhost";

    private Integer port = 9000;

    public String getPath() {
        return StringUtils.join("hdfs://", host, ":", port, "/");
    }
}
