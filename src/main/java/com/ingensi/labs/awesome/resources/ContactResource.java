package com.ingensi.labs.awesome.resources;

import com.ingensi.labs.awesome.api.Contact;
import com.ingensi.labs.awesome.core.AwesomeException;
import com.ingensi.labs.awesome.core.dao.ContactDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Contact jersey resource.
 */
@Path("/api/contact")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactResource {
    private final ContactDAO contactDAO;

    public ContactResource(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @GET
    public List<Contact> list() throws AwesomeException {
        return contactDAO.list();
    }

    @GET
    @Path("/{id}")
    public Contact get(@PathParam("id") String id) throws AwesomeException {
        return contactDAO.get(id);
    }

}
