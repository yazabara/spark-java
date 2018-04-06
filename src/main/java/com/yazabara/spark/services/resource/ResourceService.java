package com.yazabara.spark.services.resource;


import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface ResourceService {

    Dataset<Row> load(String name);
}
