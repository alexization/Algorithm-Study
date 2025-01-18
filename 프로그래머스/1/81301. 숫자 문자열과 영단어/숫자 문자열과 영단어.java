import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<String, int[]> voca = new HashMap<>();
        voca.put("ze", new int[]{0, 4});
        voca.put("on", new int[]{1, 3});
        voca.put("tw", new int[]{2, 3});
        voca.put("th", new int[]{3, 5});
        voca.put("fo", new int[]{4, 4});
        voca.put("fi", new int[]{5, 4});
        voca.put("si", new int[]{6, 3});
        voca.put("se", new int[]{7, 5});
        voca.put("ei", new int[]{8, 5});
        voca.put("ni", new int[]{9, 4});
        
        int index = 0;
        String strNum = "";
        while (index != s.length()){
            char indexChar = s.charAt(index);
            if (indexChar - '0' >= 0 && indexChar - '0' <= 9){
                strNum += indexChar;
                index++;
                continue;
            }
            
            String tempStr = "";
            tempStr += indexChar;
            tempStr += s.charAt(index + 1);
            
            int[] temp = voca.get(tempStr);
            strNum += Integer.toString(temp[0]);
            index += temp[1];
        }
        
        return Integer.parseInt(strNum);
    }
}