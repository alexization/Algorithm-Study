import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++){
            scoreMap.put(name[i], yearning[i]);
        }
        
        int index = 0;
        for (String[] temp : photo){
            int score = 0;
            for (String photoName : temp){
                score += scoreMap.getOrDefault(photoName, 0);
            }
            answer[index++] = score;
        }
        
        return answer;
    }
}