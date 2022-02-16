package com.justynsoft.da.typesafe.config;

import com.typesafe.config.Optional;

import java.util.List;

public class SparkConfig {

    private String home;
    private String master;

    private String bindingAddress;
    private String ports;
    private String executorMemory;
    private String extraJavaOptionsExecutor;
    private String deployMode;
    private boolean enableDebug;
    private String debugPort;

    private String mainClass;

    private String serviceJar;

    private String blockManagerPort;
    private String driverPort;
    private String driverMemory;

    @Optional
    private List<String> jars;

    @Optional
    private int getSparkRetryCount;

}
