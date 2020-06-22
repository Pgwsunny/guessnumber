package com.twschool.practice.api;

import com.twschool.practice.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class GameController {
    @PostMapping("/games/guess-numbers")
    public Map<String,String> guess(@RequestBody Map<String,String> requestBody){
        int times = 0;
        int scores = 0;
        GameService gameService = new GameService();
        Map resultMap = gameService.checkUserAnswer(requestBody.get("number"),times,scores);
        requestBody.put("result",(String) resultMap.get("result"));
        requestBody.put("socres",(String) resultMap.get("socres"));
        return requestBody;
    }
    /*
    public Map<String,String> guess(@RequestBody Map<String,String> requestBody){
        int count =0;
        int A =0;
        int B =0;
        int C= 0;
        String [] answer = new String[]{"1","2","3","4"};
        Map<String,String> responseBody = new HashMap<>();
        requestBody.put("input",requestBody.get("number"));
        requestBody.put("result","4A0B");
        String num = requestBody.get("number");
        String[] numArray = num.split(" ");
        Set numSet = new HashSet();
        for (String str : numArray){
            numSet.add(str);
        };
        if (numArray.length != 4){
            requestBody.put("Error","Wrong Input，Input again");
            return requestBody;
        } else if(numSet.size() != 4 ){
            requestBody.put("Error","Wrong Input，Input again");
            return requestBody;
        };
        for(int i=0;i<numArray.length;i++){
            for(int j = 0;j< answer.length;j++){
                if(numArray[j].equals(answer[i])){
                    C++;
                }
                if(numArray[j].equals(answer[j])){
                    A++;
                }
            }
        }
        B = C - A;
        String result = A + "A" + B + "B";
        requestBody.put("result",result);
        return requestBody;
    }
    */
}
