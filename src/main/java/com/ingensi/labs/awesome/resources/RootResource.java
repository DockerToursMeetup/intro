package com.ingensi.labs.awesome.resources;

import com.ingensi.labs.awesome.api.ApiInfo;
import com.ingensi.labs.awesome.core.AwesomeException;
import io.dropwizard.Configuration;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Root jersey resource.
 */
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RootResource {
    private final String hostname;
    private final Configuration configuration;

    public RootResource(String hostname, Configuration configuration) {
        this.hostname = hostname;
        this.configuration = configuration;
    }

    @GET
    public ApiInfo list() throws AwesomeException {
        return new ApiInfo(hostname, configuration);
    }
}
