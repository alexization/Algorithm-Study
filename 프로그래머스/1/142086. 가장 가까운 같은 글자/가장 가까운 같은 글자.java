import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (!indexMap.containsKey(s.charAt(i))){
                indexMap.put(s.charAt(i), i);
                answer[i] = -1;
                continue;
            }
            
            int index = indexMap.get(s.charAt(i));
            indexMap.put(s.charAt(i), i);
            
            answer[i] = i - index;
        }
        
        return answer;
    }
}