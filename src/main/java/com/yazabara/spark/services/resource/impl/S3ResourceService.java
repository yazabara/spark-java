package com.yazabara.spark.services.resource.impl;

import com.yazabara.spark.config.resource.ResourceConfig;
import com.yazabara.spark.config.resource.impl.S3Config;
import com.yazabara.spark.services.resource.AbstractResourceService;
import com.yazabara.spark.services.resource.ResourceService;
import org.springframework.stereotype.Service;

@Service("S3Resources")
public class S3ResourceService extends AbstractResourceService implements ResourceService {

    private final S3Config config;

    public S3ResourceService(S3Config s3Config) {
        this.config = s3Config;
    }

    @Override
    protected ResourceConfig getConfig() {
        return config;
    }
}
