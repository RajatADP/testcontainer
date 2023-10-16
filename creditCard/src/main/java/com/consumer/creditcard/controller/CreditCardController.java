package com.consumer.creditcard.controller;

import com.consumer.creditcard.model.DataToAdd;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardController {

    private String baseURL = "http://localhost:9000";

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }


    @PostMapping("/addValues")
    public void addAndStoreData(@RequestBody DataToAdd dataToAdd) {
        int summation = dataToAdd.getValue1() + dataToAdd.getValue2();

    }

}
