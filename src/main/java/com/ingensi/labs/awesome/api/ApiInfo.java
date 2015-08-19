package com.ingensi.labs.awesome.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Contains info about the api.
 */
public class ApiInfo {
    private final String hostname;
    private final Configuration configuration;

    public ApiInfo(
            @JsonProperty("hostname") String hostname,
            @JsonProperty("configuration") Configuration configuration) {
        this.hostname = hostname;
        this.configuration = configuration;
    }

    @JsonProperty
    public String getHostname() {
        return hostname;
    }

    @JsonProperty
    public Configuration getConfiguration() {
        return configuration;
    }
}
