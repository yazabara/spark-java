package com.yazabara.spark.services.resource.impl;

import com.yazabara.spark.config.WithResources;
import com.yazabara.spark.config.resource.Resource;
import com.yazabara.spark.config.impl.HdfsConfig;
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
    protected WithResources getConfig() {
        return config;
    }
}
