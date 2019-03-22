package com.stackroute.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/*Service for kafka*/
@Service
public class KafkaListenerService {

    @KafkaListener(topics = "SubmissionMessage", groupId = "group_id")
    public String consume(String message)
    {
        message="{\"username\":\"Pratibha\",\"questionId\":2,\"questionTitle\":\"Second One\",\"result\":\"Success\",\"testCasePassed\":10,\"totalTestCases\":10,\"difficulty\":\"medium\",\"solution\":\"This is the solution\",\"score\":30.0}";
        System.out.println("Consumed msg : " + message);
        return message;
    }
    @KafkaListener(topics = "AuthMessage", groupId = "group_id")
    public String consume1(String message1)
    {
        message1 = "{\"username\":\"Pratibha\",\"age\":22}";
        System.out.println("Consumed msg : " + message1);
        return message1;
    }
}
