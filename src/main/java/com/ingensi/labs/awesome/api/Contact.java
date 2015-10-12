package com.ingensi.labs.awesome.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contact representation class.
 */
public class Contact {
    private final String id;
    private final String firstname;
    private final String lastname;
    private final String phone;

    public Contact(
            @JsonProperty("id") String id,
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname,
            @JsonProperty("phone") String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
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

    @JsonProperty
    public String getPhone() {
        return phone;
    }
}
