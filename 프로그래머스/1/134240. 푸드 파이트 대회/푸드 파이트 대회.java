import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        ArrayList<Integer> foodCount = new ArrayList<>();
        for (int i = 1; i < food.length; i++){
            foodCount.add(food[i] / 2);
        }
        
        for (int i = 0; i < foodCount.size(); i++){
            for (int j = 0; j < foodCount.get(i); j++){
                answer += "" + (i+1);
            }
        }
        answer += "0";
        for (int i = foodCount.size() - 1; i >= 0; i--){
            for (int j = 0; j < foodCount.get(i); j++){
                answer += "" + (i+1);
            }
        }
        
        return answer;
    }
}