import java.io.*;
import java.util.*;

class Solution {
    
    static int count = 0;
    static boolean[] visited;
    
    public int solution(int[] number) {
        
        visited = new boolean[number.length];
        dfs(0, 0, number, 0);
        
        return count;
    }
    
    public static void dfs(int depth, int value, int[] number, int index){
        
        if (depth == 3){
            if (value == 0) count++;
            return;
        }
        
        for (int i = index; i < number.length; i++){
            if (visited[i]) continue;
            visited[i] = true;
            dfs(depth + 1, value + number[i], number, i);
            visited[i] = false;
        }
    }
}