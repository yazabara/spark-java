package com.yazabara.spark.services;

import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Row;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class SparkActions implements Serializable {

    public static MapFunction<Row, String> convertToString() {
        return value -> value.getAs("name");
    }
}
