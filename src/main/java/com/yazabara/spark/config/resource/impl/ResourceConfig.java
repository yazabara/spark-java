package com.yazabara.spark.config.resource.impl;

import com.yazabara.spark.config.resource.Resource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@ToString
@Getter
@Setter
public class ResourceConfig implements Resource {

    private String path;

    private String schema;

    private Map<String, String> options;
}
