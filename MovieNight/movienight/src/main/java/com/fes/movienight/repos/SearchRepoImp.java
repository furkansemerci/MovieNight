package com.fes.movienight.repos;

import com.fes.movienight.models.PostModel;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component // allows Spring to detect our custom beans automatically
public class SearchRepoImp implements SearchRepository{
    // class for searchRepository Interface implementation

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;
    // we use it to convert class into bson document


    @Override
    public List<PostModel> findByText(String text) {

        final List<PostModel> postModels = new ArrayList<>();

        MongoDatabase db = mongoClient.getDatabase("sample_mflix");
        MongoCollection<Document> collection = db.getCollection("movies");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                .append("path", Arrays.asList( "title")))),

                new Document("$limit", 15L)));

        result.forEach(doc -> postModels.add(mongoConverter.read(PostModel.class, doc)));
        return postModels;
    }


}
