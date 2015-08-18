package com.ingensi.labs.awesome.core.dao;

import com.ingensi.labs.awesome.api.Contact;
import com.ingensi.labs.awesome.core.AwesomeException;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;

import java.util.ArrayList;
import java.util.List;

/**
 * Contact DAO allows application to access contacts.
 */
public class ContactDAO {

    private final Client esClient;
    private final String esIndex;
    private final String esType;

    public ContactDAO(Client esClient, String esIndex, String esType) {
        this.esClient = esClient;
        this.esIndex = esIndex;
        this.esType = esType;
    }

    /**
     * List contacts.
     *
     * @return All stored contacts.
     */
    public List<Contact> list() throws AwesomeException {
        try {
            ArrayList<Contact> contacts = new ArrayList<>();

            SearchResponse response = esClient.prepareSearch(esIndex)
                    .setTypes(esType)
                    .setQuery(QueryBuilders.matchAllQuery())
                    .execute()
                    .actionGet();

            response.getHits().forEach(hit -> contacts.add(
                    new Contact(
                            hit.getId(),
                            (String) hit.getSource().get("firstname"),
                            (String) hit.getSource().get("lastname")
                    )
            ));

            return contacts;
        } catch (ElasticsearchException e) {
            throw new AwesomeException(e);
        }
    }

    /**
     * Get a contact.
     *
     * @param id Id of the contact.
     * @return The contact.
     */
    public Contact get(String id) throws AwesomeException {
        try {
            GetResponse response = esClient.prepareGet(esIndex, esType, id)
                    .execute()
                    .actionGet();

            return new Contact(
                    response.getId(),
                    (String) response.getSource().get("firstname"),
                    (String) response.getSource().get("lastname")
            );
        } catch (ElasticsearchException e) {
            throw new AwesomeException(e);
        }
    }
}
