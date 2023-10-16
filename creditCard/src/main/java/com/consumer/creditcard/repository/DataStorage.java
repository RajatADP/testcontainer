package com.consumer.creditcard.repository;

import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.stereotype.Repository;

@Repository
public class DataStorage {

    private MongoCollection<Document> createConnection() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("myMongoDb");

        return database.getCollection("customers");
    }

    public boolean save(int data) {
        try {
            MongoCollection<Document> collection = createConnection();
            Document document = new Document();
            document.put("name", "demo");
            document.put("sum", data);
            collection.insertOne(document);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public MongoCursor<Document> read(String key) {
        try {
            MongoCollection<Document> collection = createConnection();
            Document document = new Document();
            document.put("name", key);
            FindIterable<Document> cursor = collection.find(document);
            MongoCursor<Document> cursorIterator = cursor.cursor();
            return cursorIterator;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(String key) {
        try {
            MongoCollection<Document> collection = createConnection();
            Document searchQuery = new Document();
            searchQuery.put("name", key);
            collection.deleteOne(searchQuery);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
