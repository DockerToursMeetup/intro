package com.ingensi.labs.awesome.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contact representation class.
 */
public class Contact {
    private final String id;
    private final String firstname;
    private final String lastname;

    public Contact(
            @JsonProperty("id") String id,
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty
    public String getLastname() {
        return lastname;
    }
}
