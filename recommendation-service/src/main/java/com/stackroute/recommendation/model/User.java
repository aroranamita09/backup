package com.stackroute.recommendation.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;

@NodeEntity
public class User {

    @GraphId
    private String username;
    private Long id;
//    public User(String username, String interests, String abc) {
//        this.username = username;
//        this.interests = interests;
//        this.abc = abc;
//
//    }

    //private List<String> interests;
    private List<String> interests;

    private  String abc;

    //private List<String> tags;



//    @Relationship(type = "ATTEMPTED", direction = Relationship.INCOMING)
//    private List<Question> questions;

//    public User() {
//    }

//    public void attempt(Question question){
//        this.questions.add(question);
//    }


//
//    public void setQuestions(List<Question> questions) {
//        this.questions = questions;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
