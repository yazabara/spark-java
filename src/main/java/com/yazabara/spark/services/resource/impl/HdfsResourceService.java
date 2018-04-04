package com.yazabara.spark.services.resource.impl;

import com.yazabara.spark.config.resource.ResourceConfig;
import com.yazabara.spark.config.resource.impl.HdfsConfig;
import com.yazabara.spark.services.resource.AbstractResourceService;
import com.yazabara.spark.services.resource.ResourceService;
import org.springframework.stereotype.Service;

@Service("HdfsResources")
public class HdfsResourceService extends AbstractResourceService implements ResourceService {

    private final HdfsConfig config;

    public HdfsResourceService(HdfsConfig config) {
        this.config = config;
    }

    @Override
    protected ResourceConfig getConfig() {
        return config;
    }
}
