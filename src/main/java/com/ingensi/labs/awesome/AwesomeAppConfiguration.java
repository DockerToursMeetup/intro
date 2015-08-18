package com.ingensi.labs.awesome;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * The hello app configuration class.
 */
public class AwesomeAppConfiguration extends Configuration {
    @NotEmpty
    private final String elasticsearchHost;

    @NotNull
    private final Integer elasticsearchPort;

    public AwesomeAppConfiguration(
            @JsonProperty("elasticsearchHost") String elasticsearchHost,
            @JsonProperty("elasticsearchPort") Integer elasticsearchPort) {
        this.elasticsearchHost = elasticsearchHost;
        this.elasticsearchPort = elasticsearchPort;
    }


    @JsonProperty
    public String getElasticsearchHost() {
        return elasticsearchHost;
    }

    @JsonProperty
    public Integer getElasticsearchPort() {
        return elasticsearchPort;
    }

}