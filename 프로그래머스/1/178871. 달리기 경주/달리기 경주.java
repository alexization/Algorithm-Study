import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) { 
            rank.put(players[i], i);
        }
        
        for(String call : callings) {
            Integer ranking = rank.get(call);
            String temp = players[ranking - 1];
            players[ranking-1] = players[ranking];
            players[ranking] = temp;
        
            rank.remove(temp);
            rank.remove(call);
            
            rank.put(temp, ranking);
            rank.put(call, ranking-1);
        }
        
        return players;
    }
}