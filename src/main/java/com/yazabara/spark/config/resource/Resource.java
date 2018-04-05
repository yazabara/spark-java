package com.yazabara.spark.config.resource;

import java.util.Map;

public interface Resource {

    String getSchema();

    Map<String, String> getOptions();
}
