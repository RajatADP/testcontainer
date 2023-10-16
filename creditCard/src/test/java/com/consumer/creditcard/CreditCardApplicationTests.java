package com.consumer.creditcard;

import com.consumer.creditcard.repository.DataStorage;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreditCardApplicationTests {

    @Test
    void testMongoAddOperation() {
        DataStorage dataStorage = new DataStorage();
        dataStorage.save(5);
    }

    @Test
    void testMongoRetrieveOperation() {
        DataStorage dataStorage = new DataStorage();
        MongoCursor<Document> data = dataStorage.read("demo");
        while (data.hasNext()) {
            Document document = data.next();
            Assertions.assertTrue(document.containsValue("demo"));
            return;
        }
        Assertions.assertFalse(true);
        data.close();
    }

    @Test
    void testMongoDeleteOperation() {

        DataStorage dataStorage = new DataStorage();
        dataStorage.delete("demo");

        MongoCursor<Document> data = dataStorage.read("demo");
        while (data.hasNext()) {
            Document document = data.next();
            Assertions.assertFalse(document.containsValue("demo"));
            return;
        }
        data.close();
    }


}
