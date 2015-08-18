package com.ingensi.labs.awesome.health;

import com.codahale.metrics.health.HealthCheck;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;

/**
 * Healthcheck of elasticsearch connection.
 */

public class ElasticsearchHealthcheck extends HealthCheck {
    private final Client esClient;
    private final String index;
    private final String type;

    public ElasticsearchHealthcheck(Client esClient, String index, String type) {
        this.esClient = esClient;
        this.index = index;
        this.type = type;
    }

    @Override
    protected Result check() throws Exception {
        Result status;
        try {
            SearchResponse searchResponse = esClient.prepareSearch(index)
                    .setTypes(type)
                    .setQuery(QueryBuilders.matchAllQuery())
                    .setSize(0)
                    .execute()
                    .actionGet();

            if (searchResponse.status().equals(RestStatus.OK)) {
                status = Result.healthy();
            } else {
                status = Result.unhealthy("Test query status = " + searchResponse.status());
            }
        } catch (ElasticsearchException e) {
            status = Result.unhealthy("Test query throws an exception: " + e);
        }


        return status;
    }
}