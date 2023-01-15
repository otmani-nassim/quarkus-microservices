package org.agoncal.quarkus.microservices.number;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.ToString;

@ToString
@RegisterForReflection
public class IsbnThirteen {
    @JsonProperty("isbn13")
    public String isbn13;

    @JsonProperty("isbn10")
    public String isbn10;
}
