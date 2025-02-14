import java.io.*;
import java.util.*;

class Solution {
    
    static int totalLength;
    static boolean[] visited;
    static ArrayList<String> resultList = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {    
        totalLength = tickets.length;
        visited = new boolean[totalLength];
        
        dfs(tickets, "ICN", 1, "ICN ");
        
        Collections.sort(resultList);
        
        String[] answer = resultList.get(0).split(" ");
        return answer;
    }
    
    private static void dfs(String[][] tickets, String now, int depth, String value) {
        if (depth == totalLength + 1){
            resultList.add(value);
            return;
        }
        
        for (int i = 0; i < totalLength; i++){
            if (visited[i]) continue;
            if (!tickets[i][0].equals(now)) continue;
            
            visited[i] = true;
            String addValue = value + tickets[i][1] + " ";
            dfs(tickets, tickets[i][1], depth + 1, addValue);
            visited[i] = false;
        }
    }
}