package org.agoncal.quarkus.microservices.number;

import java.time.Instant;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;


@Path("/api/books")
@Tag(name="Book REST endpoint")
public class BookResource {

    @Inject
    Logger logger;


    @Inject
    @RestClient
    NumberProxy proxy;

    @POST
    @Fallback(fallbackMethod = "fallbackOnCreatingBook")
    @Retry(
        maxRetries = 3,
        maxDuration = 3000
    )
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createBook(
        @FormParam("title") String title,
        @FormParam("author") String author, 
        @FormParam("year") int year, 
        @FormParam("genre") String genre
    ){
        logger.info("TRY +++++++++++++++++++++++ ");
        Book book = new Book();
        IsbnThirteen res = proxy.generateIsbnNumbers();
        logger.info("RES OBTAINED: "+ res);

        book.isbn13 = res.isbn13==null? "13-shiiiit": res.isbn13;
        book.title = title;
        book.author = author;
        book.year = year;
        book.genre = genre;
        book.creation = Instant.now();
        logger.info("Book created: "+book);
        return Response.status(201).entity(book).build();
    } 

    public Response fallbackOnCreatingBook(
        String title,
        String author, 
        int year, 
        String genre
    ){
        Book book = new Book();
        book.isbn13 = "We will see later";
        book.title = title;
        book.author = author;
        book.year = year;
        book.genre = genre;
        book.creation = Instant.now();
        logger.warn("Book saved on disk: "+book);
        return Response.status(206).entity(book).build();
    }

}