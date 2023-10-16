package com.consumer.creditcard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@SpringBootTest
public class TestMongoDB {

//    @Autowired
//    private DataRepository dataRepository;

    private int port;
    private String host;


    @Container
    private MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:latest")
    ).withExposedPorts(27017);

    @BeforeEach
    private void setUp() {
        mongoDBContainer.start();
         host = mongoDBContainer.getHost();
        port = mongoDBContainer.getFirstMappedPort();
    }

    @Test
    public void checkMongoIsUpAndRunning() {
        System.out.println("running");
        System.out.println(host);
        Assertions.assertEquals(27017, port);
    }

}
