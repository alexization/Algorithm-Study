import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] answer = new int[targets.length];
        Map<Character, Integer> keymaps = new HashMap<>();
        
        for (String map : keymap){
            for (int i = 0; i < map.length(); i++){
                if (keymaps.containsKey(map.charAt(i))){
                    int temp = keymaps.get(map.charAt(i));
                    int variable = Math.min(temp, i+1);
                    keymaps.put(map.charAt(i), variable);
                    continue;
                }
                keymaps.put(map.charAt(i), i+1);
            }
        }
        
        int index = 0;
        for (String target : targets){
            int count = 0;
            boolean status = false;
            for (int i = 0; i < target.length(); i++){
                if (!keymaps.containsKey(target.charAt(i))){
                    status = true;
                    break;
                }
                count += keymaps.get(target.charAt(i));
            }

        if (status) answer[index++] = -1;
        else answer[index++] = count;
            
        }
        return answer;
    }
}