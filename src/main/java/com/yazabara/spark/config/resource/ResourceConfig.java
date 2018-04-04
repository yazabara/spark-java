package com.yazabara.spark.config.resource;

import java.util.Map;

public interface ResourceConfig {

    String getFilePath();

    String getSchema();

    Map<String, String> getOptions();
}
