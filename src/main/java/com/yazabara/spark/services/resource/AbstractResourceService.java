package com.yazabara.spark.services.resource;

import com.yazabara.spark.config.WithResources;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public abstract class AbstractResourceService implements ResourceService {

    @Override
    public Dataset<Row> load(String name) {
        //create base reader
        DataFrameReader reader = getSparkSession()
                .read()
                .schema(getConfig().getResource(name).getSchema());

        //fill all options
        getConfig().getResource(name).getOptions().forEach(reader::option);

        //read target file from resource source
        return reader
                .csv(getConfig().getResourcePath(name));
    }

    protected abstract WithResources getConfig();

    protected SparkSession getSparkSession() {
        return SparkSession.builder().getOrCreate();
    }
}
