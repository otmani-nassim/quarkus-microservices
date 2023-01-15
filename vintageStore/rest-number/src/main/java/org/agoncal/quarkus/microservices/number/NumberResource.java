package org.agoncal.quarkus.microservices.number;

import java.time.Instant;
import java.util.Random;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;


@Path("/api/numbers")
@Tag(name="Tag: endpoint numbers")
public class NumberResource{

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateIsbnNumbers(){
        IsbnNumbers isbnNumbers = new IsbnNumbers();
        isbnNumbers.isbn13 = "13-" + new Random().nextInt(100_000_000);
        isbnNumbers.isbn10 = "10-" + new Random().nextInt(100_000);
        isbnNumbers.creation = Instant.now();
        logger.info("NUMBERS GENERATED :"+isbnNumbers);
        
        return Response.status(201).entity(isbnNumbers).build();
    }

}