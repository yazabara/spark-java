package com.yazabara.spark.services.resource.impl;

import com.yazabara.spark.config.resource.ResourceConfig;
import com.yazabara.spark.config.resource.impl.FileConfig;
import com.yazabara.spark.services.resource.AbstractResourceService;
import com.yazabara.spark.services.resource.ResourceService;
import org.springframework.stereotype.Service;

@Service("FileResources")
public class FileResourceService extends AbstractResourceService implements ResourceService {

    private final FileConfig config;

    public FileResourceService(FileConfig fileConfig) {
        this.config = fileConfig;
    }

    @Override
    protected ResourceConfig getConfig() {
        return config;
    }
}
