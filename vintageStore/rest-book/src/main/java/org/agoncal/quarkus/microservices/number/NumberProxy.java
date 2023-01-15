package org.agoncal.quarkus.microservices.number;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.runtime.annotations.RegisterForReflection;

@Path("api/numbers")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey="number-proxy")
@RegisterForReflection
public interface NumberProxy {
    @GET
    IsbnThirteen generateIsbnNumbers();
}
