package com.consumer.creditcard.repository;

import com.consumer.creditcard.model.DataToAdd;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository<DataToAdd, String> {
}
