import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] graph = new int[rows][columns];
        
        int count = 1;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                graph[i][j] = count++;
            }
        }
        
        int index = 0;
        for (int[] query : queries){
            int minValue = Integer.MAX_VALUE;
            
            int sx = query[0] - 1;
            int sy = query[1] - 1;
            int ex = query[2] - 1;
            int ey = query[3] - 1;
            
            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = sy; i <= ey; i++){
                int value = graph[sx][i];
                minValue = Math.min(minValue, value);
                dq.add(value);
            }
            
            for (int i = sx+1; i < ex; i++){
                int value = graph[i][ey];
                minValue = Math.min(minValue, value);
                dq.add(value);
            }
            
            for (int i = ey; i >= sy; i--){
                int value = graph[ex][i];
                minValue = Math.min(minValue, value);
                dq.add(value);
            }
            
            for (int i = ex - 1; i > sx; i--){
                int value = graph[i][sy];
                minValue = Math.min(minValue, value);
                dq.add(value);
            }
            answer[index++] = minValue;
            
            dq.addFirst(dq.pollLast());
            
            for (int i = sy; i <= ey; i++){
                graph[sx][i] = dq.poll();
            }
            
            for (int i = sx+1; i < ex; i++){
                graph[i][ey] = dq.poll();
            }
            
            for (int i = ey; i >= sy; i--){
                graph[ex][i] = dq.poll();
            }
            
            for (int i = ex - 1; i > sx; i--){
                graph[i][sy] = dq.poll();
            }
        }
        
        return answer;
    }
}