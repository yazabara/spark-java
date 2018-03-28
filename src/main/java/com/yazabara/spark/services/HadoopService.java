package com.yazabara.spark.services;

import com.yazabara.spark.config.S3Config;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@ToString
public class HadoopService {

    public final S3Config s3Config;

    public HadoopService(S3Config s3Config) {
        this.s3Config = s3Config;
    }

}
