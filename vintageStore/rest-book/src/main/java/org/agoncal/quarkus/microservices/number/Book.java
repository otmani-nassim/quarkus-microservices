package org.agoncal.quarkus.microservices.number;
import java.time.Instant;

import lombok.ToString;
import javax.json.bind.annotation.JsonbProperty;

import io.quarkus.runtime.annotations.RegisterForReflection;

@ToString
@RegisterForReflection
public class Book {
    @JsonbProperty("isbn13")
    public String isbn13;

    @JsonbProperty("title")
    public String title;

    @JsonbProperty("author")
    public String author;

    @JsonbProperty("year")
    public int year;

    @JsonbProperty("genre")
    public String genre;

    @JsonbProperty("creation")
    public Instant creation;
}