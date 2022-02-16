package com.justynsoft.da.typesafe.config;

import com.typesafe.config.Optional;

public class ExtractConfig {
    public String directory;

    @Optional
    private long pollInSeconds;
    private String filePattern;
    private String dataConfigYaml;

    @Optional
    private String destinationDir;

    @Optional
    private String DestinationFilePattern;

    @Optional
    private String destinationDB;
}
