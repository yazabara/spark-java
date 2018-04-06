package com.yazabara.spark.services.resource.impl;

import com.yazabara.spark.config.WithResources;
import com.yazabara.spark.config.impl.DbConfig;
import com.yazabara.spark.services.resource.AbstractResourceService;
import com.yazabara.spark.services.resource.ResourceService;
import org.apache.commons.collections.MapUtils;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.stereotype.Service;

@Service("DbResources")
public class DbResourceService extends AbstractResourceService implements ResourceService {

    private final DbConfig config;

    public DbResourceService(DbConfig config) {
        this.config = config;
    }

    @Override
    public Dataset<Row> load(String name) {
        validateLoadRequest(name);
        //create base reader
        DataFrameReader reader = getSparkSession()
                .read()
                .format("jdbc");

        //set common options
        config.getOptions().forEach(reader::option);
        //set resource options
        if (MapUtils.isNotEmpty(getConfig().getResource(name).getOptions())) {
            getConfig().getResource(name).getOptions().forEach(reader::option);
        }
        //read target file from resource source
        return reader
                .option("dbtable", config.getResourcePath(name))
                .load();
    }

    @Override
    protected WithResources getConfig() {
        return config;
    }
}
