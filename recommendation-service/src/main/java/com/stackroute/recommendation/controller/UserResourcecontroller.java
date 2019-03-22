package com.stackroute.recommendation.controller;


import com.stackroute.recommendation.model.Question;
import com.stackroute.recommendation.model.SubmissionScoreDetails;
import com.stackroute.recommendation.model.User;
import com.stackroute.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/")
@CrossOrigin("*")
public class UserResourcecontroller {


    public UserService userService;

    @Autowired
    public UserResourcecontroller(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "abc")
    public ResponseEntity<?> getUser(@RequestBody SubmissionScoreDetails submissionScoreDetails){
        String abc="10:10:10";
        double  maxscore=submissionScoreDetails.getMaxscore();
        double score=submissionScoreDetails.getScore();
        String currentlevel=submissionScoreDetails.getLevel();

        if(currentlevel=="medium")
            score=score/2;
        if (currentlevel=="hard")
            score=score/3;

        String arr[]=abc.split( "[:\"]");



        int  easy=Integer.parseInt(arr[0]);
        int  medium=Integer.parseInt(arr[1]);
        int  hard= Integer.parseInt(arr[2]);



        if(score>maxscore)
        {
           if(score==9||score==10)
           {
                if(currentlevel=="easy")
                {
                   medium++;
                   easy--;

                }
                else if(currentlevel=="medium")
                {
                    easy--;
                    hard++;
                }
                else
                {
                    hard++;
                    easy--;
                }
           }
           else if(score>=0&&score<=6)
           {
               if(currentlevel=="medium")
               {
                   easy++;
                   hard--;
               }
               else if(currentlevel=="easy")
               {
                   easy++;
                   hard--;
               }
               else
               {
                   medium++;
                   hard--;
               }
           }
           else
           {
               if(currentlevel=="medium")
               {
                   medium++;
                   easy--;
               }
               else if(currentlevel=="easy")
               {
                   easy++;
                   hard--;
               }
               else
               {
                   hard++;
                   easy--;
               }
           }

        }

        String basic1=String.valueOf(easy);
        String medium1=String.valueOf(medium);
        String hard1=String.valueOf(hard);

        ResponseEntity responseEntity;


        responseEntity = new ResponseEntity<String>(basic1+":"+medium1+":"+hard1,HttpStatus.CREATED);

        return responseEntity;
    }

   //ye comments kyu hai?????
    //save question
    @PostMapping(value = "registration")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        user.setAbc("10:10:10");

        ResponseEntity responseEntity;

        User user1 = userService.createUserNode(user);
        responseEntity = new ResponseEntity<User>(user1, HttpStatus.CREATED);

        return responseEntity;
    }


    //@PostMapping(value="getquestion")

//    @GetMapping(value="users")
//    public ResponseEntity<?> getAllUsers() {
//        System.out.println("hello");
//         List<User> userList=userService.getAllUsers();
//         ResponseEntity responseEntity;
//        responseEntity = new ResponseEntity<List<User>>(userList,HttpStatus.CREATED);
//
//        return responseEntity;
//    }
//
    @GetMapping(value = "questions")
    public List<Question> getAllQuestions(){
        return userService.getAllQuestions();
    }

//
//        //save question
//    @PostMapping(value = "question")
//    public ResponseEntity<?> saveQuestion(@RequestBody Question question){
//
//        ResponseEntity responseEntity;
//        Question question1 = userService.createQuestionNode(question);
//        responseEntity = new ResponseEntity<Question>(question1,HttpStatus.CREATED);
//
//        return responseEntity;
//    }
//
////    @PutMapping(value = "userupdate")
////    public ResponseEntity<?> updateUser(@RequestBody User user){
////        ResponseEntity responseEntity;
////        User user1 = userService.updateUserNode(user);
////        responseEntity = new ResponseEntity<User>(user1,HttpStatus.ACCEPTED);
////        return responseEntity;
////    }
//
//    @PutMapping(value = "questionupdate")
//    public ResponseEntity<?> updateQuestion(@RequestBody Question question){
//        ResponseEntity responseEntity;
//        Question question1 = userService.updateQuestionNode(question);
//        responseEntity = new ResponseEntity<Question>(question1,HttpStatus.ACCEPTED);
//        return responseEntity;
//    }
//
//    @DeleteMapping(value = "userdelete")
//    public ResponseEntity<?> deleteUser(@RequestBody User user){
//        ResponseEntity responseEntity;
//        User user1 = userService.deleteUser(user);
//        responseEntity = new ResponseEntity<User>(user1,HttpStatus.ACCEPTED);
//        return responseEntity;
//    }
//
//    @DeleteMapping(value = "questiondelete")
//    public ResponseEntity<?> deleteQuestion(@RequestBody Question question){
//        ResponseEntity responseEntity;
//        Question question1 = userService.deleteQuestion(question);
//        responseEntity = new ResponseEntity<Question>(question1,HttpStatus.ACCEPTED);
//        return responseEntity;
//    }
//
////    @PostMapping(value = "relationship/{emailId}/{questionId}")
////    public void addNewRelationship(@PathVariable(value = "emailId") String emailId,@PathVariable(value = "questionId") String questionId){
////        userService.addNewRelationship(emailId,questionId);
////
////    }
//    @PostMapping(value = "relationship/{emailId}/{questionId}")
//    public ResponseEntity<?> addNewRelationship(@PathVariable String emailId,@PathVariable String questionId){
//        ResponseEntity responseEntity;
//
//        responseEntity = new ResponseEntity<String>(userService.addNewRelationship(emailId,questionId), HttpStatus.OK);
//
//        return responseEntity;
//    }
//
////    @GetMapping(value = "questions")
////    public List<Question> getQuestionsBasedOnAttempts(){
////        return userService.recommendOnAttempts();
////    }
//
////    @GetMapping(value = "attempted")
////    public ResponseEntity <?> getQuestionsBasedOnAttempts(@RequestBody User user){
////
////        ResponseEntity responseEntity;
////
////
////        responseEntity = new ResponseEntity<List<Question>>(userService.recommendOnAttempts(user),HttpStatus.OK);
////
////        return responseEntity;
////    }
//
////    @GetMapping(value = "interest")
////    public ResponseEntity <?> getQuestionsBasedOnInterests(@RequestBody User user){
////
////        ResponseEntity responseEntity;
////
////
////        responseEntity = new ResponseEntity<List<Question>>(userService.recommendOnInterest(user),HttpStatus.OK);
////
////        return responseEntity;
////    }
}
