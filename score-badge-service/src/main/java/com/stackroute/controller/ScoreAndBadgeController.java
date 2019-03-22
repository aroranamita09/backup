package com.stackroute.controller;
import com.stackroute.domain.Score;
import com.stackroute.service.KafkaListenerService;
import com.stackroute.service.ScoreAndBadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


//Main controller
/*Controller class*/
@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/")
public class ScoreAndBadgeController {

    private ScoreAndBadgeService scoreAndBadgeService;
    private KafkaListenerService kafkaListenerService;

    @Autowired
    public ScoreAndBadgeController(ScoreAndBadgeService scoreAndBadgeService,KafkaListenerService kafkaListenerService) {
        this.scoreAndBadgeService = scoreAndBadgeService;
        this.kafkaListenerService=kafkaListenerService;
    }
    //method to post data
    @PostMapping("saveScore")
    public ResponseEntity<?> saveTotalScore(){
        Score score=new Score();
        String message1="";
        String registeredUserData = kafkaListenerService.consume(message1);
        String splittedData[] = registeredUserData.trim().split(",");
        String submitteduserdata[] = splittedData[0].trim().split(":");
        String registeredUserName = submitteduserdata[1].trim().split("\"")[1];
        score.setUserName(registeredUserName);
        score.setTotalScore(0.0);
        Score saveUser = scoreAndBadgeService.saveTotalScore(score);
        return new ResponseEntity<Score>(saveUser,HttpStatus.OK);
    }

    //method to update data
    @PutMapping("updateScore")
    public ResponseEntity<?> updateTotalScore(){
        Score score=new Score();
        String message="";
        String submittedData = kafkaListenerService.consume(message);
        String submitValues[] = submittedData.trim().split(",");
        String submittedusername[] = submitValues[0].trim().split(":");
        String scoreVal[] = submitValues[8].trim().split(":");
        String userName =submittedusername[1].trim().split("\"")[1];
        score.setUserName(userName);
        Date date=new Date();
        double scoreOfQuestion=Double.parseDouble(scoreVal[1].trim().split("}")[0]);
        //method to store username and calculate total score
        Score retScore = scoreAndBadgeService.calcAndUpdateTotalScore(score,scoreOfQuestion);
        return new ResponseEntity<Score>(retScore, HttpStatus.OK);
    }

    //method to get User Data
    @GetMapping("getTotalScore/{userName}")
    public ResponseEntity<?> getTotalScoreController(@PathVariable(value = "userName") String userName){
        Score score = new Score();
        score = scoreAndBadgeService.getTotalScore(userName);
        return new ResponseEntity<Score>(score, HttpStatus.OK);
    }

}
