package com.ingensi.labs.awesome.core.dao;

import com.ingensi.labs.awesome.api.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Contact DAO allows application to access contacts.
 */
public class ContactDAO {

    public List<Contact> list() {
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("fakeId1", "fakeFirstName1", "fakeLastName1"));
        contacts.add(new Contact("fakeId2", "fakeFirstName2", "fakeLastName2"));
        contacts.add(new Contact("fakeId3", "fakeFirstName3", "fakeLastName3"));
        contacts.add(new Contact("fakeId4", "fakeFirstName4", "fakeLastName4"));

        return contacts;
    }

    public Contact get(String id) {
        return new Contact("fakeId1", "fakeFirstName", "fakeLastName");
    }
}
