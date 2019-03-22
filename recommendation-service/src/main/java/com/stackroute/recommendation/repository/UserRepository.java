package com.stackroute.recommendation.repository;


import com.stackroute.recommendation.model.Question;
import com.stackroute.recommendation.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//LOAD CSV WITH HEADERS FROM "file:///question-seedData.csv" as line
@Repository
public interface UserRepository extends Neo4jRepository<User,String > {


    // Get all functions

    @Query("MATCH (u:User) RETURN u")
    List<User> getAllUsers();

    @Query("MATCH (n:Question) RETURN n")
    List<Question> getAllQuestions();


    //@Query("MATCH (u:User)<-[a:ATTEMPTED]-(q:Question) RETURN u,a,q")
    //List<User> getAllUsersRelations();



    //Save functions

    @Query("CREATE(user:User{username:{username},abc:{abc},interests:{interests}})")
    User saveUser(@Param("username") String username, @Param("abc") String abc , @Param("interests") List<String>interests);

    @Query("MATCH (u:User{username:'bhaak2'}) RETURN u")
    User findByUsername(@Param("username") String username);

    @Query("MATCH (q:Question{questionId:{questionId}}) return q")
    Question findquestionbyId(@Param("questionId") String  questionId);
//    //User findByUsername(String username);
//
//
//    @Query("CREATE(question:Question{questionId:{questionId},questionTitle:{questionTitle},difficulty:{difficulty},tags:{tags}})")
//    Question saveQuestion(@Param("questionId") String questionId,@Param("questionTitle") String questionTitle,@Param("difficulty") String difficulty,@Param("tags") String tags);
//
//
//
//    //Update functions
//
//    @Query("MATCH (n:User{emailId:{emailId}}) SET n.name={name} SET n.interests={interests}")
//    User updateUserNode(@Param("emailId") String emailId,@Param("name") String name,@Param("interests") String interests);
//
//    @Query("MATCH (q:Question{questionId:{questionId}}) SET q.questionTitle={questionTitle} SET q.difficulty={difficulty} SET q.tags={tags}")
//    Question updateQuestionNode(@Param("questionId") String questionId,@Param("questionTitle") String questionTitle,@Param("difficulty") String difficulty,@Param("tags") String tags);
//
//
//    //Delete functions
//
//    @Query("MATCH (n:User{emailId:{emailId}}) DELETE n")
//    User deleteUser(@Param("emailId") String emailId);
//
//    @Query("MATCH (q:Question{questionId:{questionId}}) DELETE q")
//    Question deleteQuestion(@Param("questionId") String questionId);
//
//    //Relationship add
//    @Query("MATCH (user:User{emailId:{emailId}}), (question:Question{questionId:{questionId}}) CREATE (user)-[:ATTEMPTED]->(question)")
//    void addNewRelationship(@Param("emailId") String emailId, @Param("questionId") String questionId);
//
//    @Query("MATCH (o:Question) WHERE o.tags = {interests} RETURN o")
//    List<Question> recommendOnInterest(@Param("interests") String interests);
//
//    @Query("MATCH (q:Question)<-[:ATTEMPTED]-(u:User{emailId:{emailId}}) MATCH (a:Question{tags:q.tags})<-[:subconcept_of]-(l:Level) RETURN a")
//    List<Question> recommendOnAttempts(@Param("emailId") String emailId);
}
