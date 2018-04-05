package com.yazabara.spark.config;

import com.yazabara.spark.config.resource.Resource;

public interface WithResources {

    Resource getResource();

    String getResourcePath();
}
