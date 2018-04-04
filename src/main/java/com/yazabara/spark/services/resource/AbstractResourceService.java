package com.yazabara.spark.services.resource;

import com.yazabara.spark.config.resource.ResourceConfig;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public abstract class AbstractResourceService implements ResourceService {

    @Override
    public Dataset<Row> load() {
        //create base reader
        DataFrameReader reader = getSparkSession()
                .read()
                .schema(getConfig().getSchema());

        //fill all options
        getConfig().getOptions().forEach(reader::option);

        //read target file from resource source
        return reader
                .csv(getConfig().getFilePath());
    }

    protected abstract ResourceConfig getConfig();

    protected SparkSession getSparkSession() {
        return SparkSession.builder().getOrCreate();
    }
}
