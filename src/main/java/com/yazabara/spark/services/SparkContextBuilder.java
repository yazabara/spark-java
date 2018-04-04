package com.yazabara.spark.services;

import com.yazabara.spark.config.resource.impl.S3Config;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.stereotype.Service;

@Service
public class SparkContextBuilder {

    private final S3Config s3Config;

    public SparkContextBuilder(S3Config s3Config) {
        this.s3Config = s3Config;
    }

    public JavaSparkContext createJavaSparkContext() {
        SparkConf conf = new SparkConf();
        conf.setAppName("test");
        if (conf.get("spark.master", null) == null) {
            conf.setMaster("local[4]");
        }
        conf.set("spark.hadoop.fs.s3a.endpoint", s3Config.getEndpoint());
        conf.set("spark.hadoop.fs.s3a.access.key", s3Config.getKey());
        conf.set("spark.hadoop.fs.s3a.secret.key", s3Config.getSecret());

        //important property
        System.setProperty("com.amazonaws.services.s3.enableV4", "true");
        return new JavaSparkContext(conf);
    }
}
