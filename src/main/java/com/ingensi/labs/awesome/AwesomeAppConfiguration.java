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

    @NotEmpty
    private final String elasticsearchCluster;

    @NotEmpty
    private final String index;

    @NotEmpty
    private final String type;

    public AwesomeAppConfiguration(
            @JsonProperty("elasticsearchHost") String elasticsearchHost,
            @JsonProperty("elasticsearchPort") Integer elasticsearchPort,
            @JsonProperty("elasticsearchCluster") String elasticsearchCluster,
            @JsonProperty("index") String index,
            @JsonProperty("port") String type) {
        this.elasticsearchHost = elasticsearchHost;
        this.elasticsearchPort = elasticsearchPort;
        this.elasticsearchCluster = elasticsearchCluster;
        this.index = index;
        this.type = type;
    }


    @JsonProperty
    public String getElasticsearchHost() {
        return elasticsearchHost;
    }

    @JsonProperty
    public Integer getElasticsearchPort() {
        return elasticsearchPort;
    }

    @JsonProperty
    public String getElasticsearchCluster() {
        return elasticsearchCluster;
    }

    @JsonProperty
    public String getIndex() {
        return index;
    }

    @JsonProperty
    public String getType() {
        return type;
    }
}