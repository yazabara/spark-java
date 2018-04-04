package com.yazabara.spark.services;

import com.yazabara.spark.config.resource.impl.HdfsConfig;
import com.yazabara.spark.config.resource.impl.S3Config;
import com.yazabara.spark.services.resource.ResourceService;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HadoopService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HadoopService.class);

    private final S3Config s3Config;
    private final HdfsConfig hdfsConfig;
    private final ResourceService resourceService;
    private JavaSparkContext sparkContext;

    public HadoopService(S3Config s3Config, HdfsConfig hdfsConfig, @Qualifier("S3Resources") ResourceService resourceService, SparkContextBuilder sparkContextBuilder) {
        this.s3Config = s3Config;
        this.hdfsConfig = hdfsConfig;
        this.resourceService = resourceService;
        this.sparkContext = sparkContextBuilder.createJavaSparkContext();
        LOGGER.info("Configuration: S3: {}, HDFS: {}", s3Config, hdfsConfig);
    }


    public void calculate() {
        Dataset<Row> json = resourceService.load();
//        getSparkSession()
//                .read()
//                .schema("id INT, name STRING")
//                .option("header", "true")
//                .csv("src/main/resources/spark-resources/input.csv");
//                .format("json")
//                .json("src/main/resources/spark-resources/input.json");

//        json.write().csv(hdfsConfig.getPath() + "output.csv");
//
//        Dataset<Row> csv = getSparkSession()
//                .read()
//                .schema("id INT, name STRING")
//                .option("header", "true")
//                .csv(hdfsConfig.getPath() + "output.csv");

//        csv
//                .map((MapFunction<Row, String>) value -> value.getAs("name"), Encoders.STRING())
//                .show();
        json.show();
    }

    private SparkSession getSparkSession() {
        return SparkSession.builder().getOrCreate();
    }
}
