package com.yazabara.spark.services;

import com.yazabara.spark.config.HdfsConfig;
import com.yazabara.spark.config.S3Config;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HadoopService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HadoopService.class);

    private final S3Config s3Config;
    private final HdfsConfig hdfsConfig;
    private final SparkActions sparkActions;
    private JavaSparkContext sparkContext;

    public HadoopService(S3Config s3Config, HdfsConfig hdfsConfig, SparkActions sparkActions, SparkContextBuilder sparkContextBuilder) {
        this.s3Config = s3Config;
        this.hdfsConfig = hdfsConfig;
        this.sparkActions = sparkActions;
        this.sparkContext = sparkContextBuilder.createJavaSparkContext();
        LOGGER.info("Configuration: S3: {}, HDFS: {}", s3Config, hdfsConfig);
    }


    public void calculate() {
        Dataset<Row> json = getSparkSession()
                .read()
                .schema("id INT, name STRING")
                .option("header", "true")
                .csv("src/main/resources/spark-resources/input.csv");
//                .format("json")
//                .json("src/main/resources/spark-resources/input.json");

        json.write().csv(hdfsConfig.getPath() + "output.csv");

        json
                .map(SparkActions.convertToString(), Encoders.STRING())
                .show();
    }

    private SparkSession getSparkSession() {
        return SparkSession.builder().getOrCreate();
    }
}
