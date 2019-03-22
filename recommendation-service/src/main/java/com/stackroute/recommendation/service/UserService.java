package com.stackroute.recommendation.service;



//import javax.management.Query;
//import java.util.List;

import com.stackroute.recommendation.model.Question;
import com.stackroute.recommendation.model.SubmissionScoreDetails;
import com.stackroute.recommendation.model.User;
import com.stackroute.recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class UserService {


    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUserNode(User user){
        return userRepository.saveUser(user.getUsername(),user.getAbc(),user.getInterests());
    }

    public String changeABC(SubmissionScoreDetails submissionScoreDetails)
    {
      System.out.println(submissionScoreDetails.getUsername());
      User u1= userRepository.findByUsername(submissionScoreDetails.getUsername());
     return u1.getAbc();


    }

//    public List<User> getAllUsers() {
//        return userRepository.getAllUsers();
//    }
//   public List<User> getAllQuestion2(){
//
//      return null;
//    }
//
    public List<Question> getAllQuestions(){
         // return userRepository.getAllQuestions();
        Random rand = new Random();
        int arr[]=new int [10];

        for(int i=0;i<10;i++)
        {
           int rand_int1 =1+rand.nextInt(45);
           int  j=0;
           while(j<i)
           {
               if(arr[i]==rand_int1)
               {
                   rand_int1=1+rand.nextInt(45);
                   j=0;
               }
               j++;
           }
           arr[i]=rand_int1;
        }
        for(int i=0;i<10;i++)
            System.out.print(arr[i]+" ");

         List<Question> qlist=new ArrayList<Question>();
         for(int i=0;i<10;i++)
         {
             Question q1=userRepository.findquestionbyId(String.valueOf(arr[i]));
             qlist.add(q1);
         }
         return qlist;

    }

//    //List<User>  getAllUsersRelations();
//
//
//
//
//    public Question createQuestionNode(Question question){
//        return userRepository.saveQuestion(question.getQuestionId(),question.getQuestionTitle(),question.getDifficulty(),question.getTags());
//    }
//
////    public User updateUserNode(User user){
////        return userRepository.updateUserNode(user.getUsername(),user.getUsername(),user.getInterests());
////    }
//
//    public Question updateQuestionNode(Question question){
//        return userRepository.updateQuestionNode(question.getQuestionId(),question.getQuestionTitle(),question.getDifficulty(),question.getTags());
//    }
//
//    public User deleteUser(User user){
//        return userRepository.deleteUser(user.getUsername());
//    }
//
//    public Question deleteQuestion(Question question){
//        return userRepository.deleteQuestion(question.getQuestionId());
//    }
//
//    public String addNewRelationship(String emailId,String questionId){
//        userRepository.addNewRelationship(emailId,questionId);
//        return "hello";
//    }
//
//    public List<Question> recommendOnAttempts(User user){
//        return userRepository.recommendOnAttempts(user.getUsername());
//
//    }
//
////    public List<Question> recommendOnInterest(User user){
////        return  userRepository.recommendOnInterest(user.getInterests());
////
////
////    }

}
