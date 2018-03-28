package com.yazabara.spark.services;

import com.yazabara.spark.config.S3Config;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HadoopService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HadoopService.class);

    private final S3Config s3Config;
    private final SparkContextBuilder sparkContextBuilder;
    private JavaSparkContext sparkContext;

    public HadoopService(S3Config s3Config, SparkContextBuilder sparkContextBuilder) {
        this.s3Config = s3Config;
        this.sparkContextBuilder = sparkContextBuilder;
        this.sparkContext = sparkContextBuilder.createJavaSparkContext();
        LOGGER.info("S3 configuration: {}", s3Config);
    }


    public void calculate() {

    }

}
