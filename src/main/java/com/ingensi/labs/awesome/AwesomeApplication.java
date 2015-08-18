package com.ingensi.labs.awesome;

/**
 * Main dropwizard class.
 */

import com.ingensi.labs.awesome.core.dao.ContactDAO;
import com.ingensi.labs.awesome.health.ElasticsearchHealthcheck;
import com.ingensi.labs.awesome.resources.ContactResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class AwesomeApplication extends Application<AwesomeAppConfiguration> {
    public static void main(String[] args) throws Exception {
        new AwesomeApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<AwesomeAppConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(AwesomeAppConfiguration configuration,
                    Environment environment) {

        // INSTANTIATIONS
        //////////////////

        // create elasticsearch client
        Client esClient = getEsClient(configuration.getElasticsearchHost(), configuration.getElasticsearchPort());

        // create DAOs
        ContactDAO contactDAO = new ContactDAO(esClient, configuration.getIndex(), configuration.getType());

        // create Resources
        ContactResource contactResource = new ContactResource(contactDAO);

        // create Healthchecks
        ElasticsearchHealthcheck elasticsearchHealthcheck = new ElasticsearchHealthcheck(esClient, configuration.getIndex(), configuration.getType());

        // REGISTRATIONS
        /////////////////

        // register Resources
        environment.jersey().register(contactResource);

        // register healthchecks
        environment.healthChecks().register("elasticsearch", elasticsearchHealthcheck);
    }

    private Client getEsClient(String host, Integer port) {
        return new TransportClient()
                .addTransportAddress(new InetSocketTransportAddress(host, port));
    }

}
