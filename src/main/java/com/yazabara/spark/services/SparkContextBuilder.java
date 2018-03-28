package com.yazabara.spark.services;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.stereotype.Service;

@Service
public class SparkContextBuilder {

    public JavaSparkContext createJavaSparkContext() {
        SparkConf conf = new SparkConf();
        conf.setAppName("test");
        if (conf.get("spark.master", null) == null) {
            conf.setMaster("local[4]");
        }
        return new JavaSparkContext(conf);
    }
}
