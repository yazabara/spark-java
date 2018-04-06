package com.yazabara.spark.services.resource;

import com.yazabara.spark.config.WithResources;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public abstract class AbstractResourceService implements ResourceService {

    @Override
    public Dataset<Row> load(String name) {
        validateLoadRequest(name);
        //create base reader
        DataFrameReader reader = getSparkSession()
                .read()
                .schema(getConfig().getResource(name).getSchema());

        //fill all options
        if (MapUtils.isNotEmpty(getConfig().getResource(name).getOptions())) {
            getConfig().getResource(name).getOptions().forEach(reader::option);
        }

        //read target file from resource source
        return reader
                .csv(getConfig().getResourcePath(name));
    }

    protected abstract WithResources getConfig();

    protected void validateLoadRequest(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name argument must be not blank.");
        }
        if (getConfig().getResource(name) == null) {
            throw new IllegalArgumentException("Unable to get resource by name: " + name);
        }
    }

    protected SparkSession getSparkSession() {
        return SparkSession.builder().getOrCreate();
    }
}
