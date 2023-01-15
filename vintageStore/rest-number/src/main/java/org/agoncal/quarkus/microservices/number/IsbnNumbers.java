package org.agoncal.quarkus.microservices.number;

import java.time.Instant;

import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.runtime.annotations.RegisterForReflection;

@ToString
@RegisterForReflection
public class IsbnNumbers {

    @JsonProperty("isbn10")
    public String isbn10;

    @JsonProperty("isbn13")
    public String isbn13;

    @JsonProperty("creation")
    public Instant creation;
}
