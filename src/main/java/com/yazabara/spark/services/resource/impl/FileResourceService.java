package com.yazabara.spark.services.resource.impl;

import com.yazabara.spark.config.WithResources;
import com.yazabara.spark.config.resource.Resource;
import com.yazabara.spark.config.impl.FileConfig;
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
    protected WithResources getConfig() {
        return config;
    }
}
