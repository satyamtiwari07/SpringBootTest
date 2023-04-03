package com.example.drivername.repository;

import com.example.drivername.model.Driver;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class searchrepoimple implements searchrepo{

    @Autowired
    MongoClient mc;
    @Autowired
    MongoConverter convert;

    @Override
    public List<Driver> searchtext(String text) {
        final List<Driver>drivers = new ArrayList<>();

        MongoDatabase database = mc.getDatabase("Satyam");
        MongoCollection<Document> collection = database.getCollection("drivername");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                        new Document("query", text)
                                .append("path", "profile"))),
                        new Document("$sort",
                        new Document("exp", -1L)),
                        new Document("$limit", 2L)));

        result.forEach(doc->drivers.add(convert.read(Driver.class , doc)));

        return drivers;
    }
}
