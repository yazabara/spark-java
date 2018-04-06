package com.yazabara.spark.services;

import com.yazabara.spark.services.resource.ResourceService;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HadoopService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HadoopService.class);

    private final ResourceService resourceService;
    private JavaSparkContext sparkContext;

    public HadoopService(@Qualifier("DbResources") ResourceService resourceService, SparkContextBuilder sparkContextBuilder) {
        this.resourceService = resourceService;
        this.sparkContext = sparkContextBuilder.createJavaSparkContext();
    }

    public void calculate() {
        LOGGER.info("Calculating started.");
        resourceService
                .load("test")
                .show();
        LOGGER.info("Calculating finished.");
    }
}
