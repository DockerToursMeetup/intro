package com.ingensi.labs.awesome;

/**
 * Main dropwizard class.
 */

import com.ingensi.labs.awesome.core.dao.ContactDAO;
import com.ingensi.labs.awesome.resources.ContactResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
        ContactDAO contactDAO = new ContactDAO();
        ContactResource contactResource = new ContactResource(contactDAO);

        environment.jersey().register(contactResource);
    }

}
