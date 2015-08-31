package com.ingensi.labs.awesome;

/**
 * Main dropwizard class.
 */

import com.ingensi.labs.awesome.core.dao.ContactDAO;
import com.ingensi.labs.awesome.health.ElasticsearchHealthcheck;
import com.ingensi.labs.awesome.resources.ContactResource;
import com.ingensi.labs.awesome.resources.RootResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
        Client esClient = getEsClient(configuration.getElasticsearchHost(), configuration.getElasticsearchPort(), configuration.getElasticsearchCluster());

        // create DAOs
        ContactDAO contactDAO = new ContactDAO(esClient, configuration.getIndex(), configuration.getType());

        // create Resources
        ContactResource contactResource = new ContactResource(contactDAO);
        RootResource rootResource = new RootResource(getHostname(), configuration);

        // create Healthchecks
        ElasticsearchHealthcheck elasticsearchHealthcheck = new ElasticsearchHealthcheck(esClient, configuration.getIndex(), configuration.getType());

        // REGISTRATIONS
        /////////////////

        // register Resources
        environment.jersey().register(contactResource);
        environment.jersey().register(rootResource);

        // register healthchecks
        environment.healthChecks().register("elasticsearch", elasticsearchHealthcheck);
    }

    private String getHostname() {
        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ignored) {
        }

        return hostname;
    }

    private Client getEsClient(String host, Integer port, String elasticsearch) {
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("cluster.name", elasticsearch).build();
        return new TransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(host, port));
    }

}
