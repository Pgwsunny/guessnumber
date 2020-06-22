package com.twschool.practice.service;

import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GameAnswer;
import com.twschool.practice.domain.GuessNumberGame;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;

public class GameService {
    public Map checkUserAnswer(String userAnswer,int times,int socres){
        int winrepeat = 0;
        AnswerGenerator answerGenerator = new AnswerGenerator();
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGenerator);
        String result = guessNumberGame.guess(userAnswer);
        if(guessNumberGame.getStatus().equals("SUCCEED")){
            times++;
            winrepeat++;
            socres +=3;
        }else{
            times--;
            socres -=3;
            winrepeat = 0;
        }
        if((winrepeat | 3) == 0){
            socres +=2;
        }else if((winrepeat | 5) ==0){
            socres +=3;
        }
        Map resultMap = new HashMap();
        resultMap.put("result",result);
        resultMap.put("socres",socres);
        return resultMap;
    }
}
