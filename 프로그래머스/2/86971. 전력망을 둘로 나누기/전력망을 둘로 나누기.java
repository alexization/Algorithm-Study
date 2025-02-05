import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        boolean[] status = new boolean[n];
        for (int i = 0; i < n - 1; i++){
            status[i] = true;
            
            ArrayList<Integer>[] graph = new ArrayList[n+1];
            for (int k = 0; k <= n; k++){
                graph[k] = new ArrayList<>();
            }
            
            for (int j = 0; j < n - 1; j++){
                if (status[j]) continue;
                graph[wires[j][0]].add(wires[j][1]);
                graph[wires[j][1]].add(wires[j][0]);
            }
            
            visited = new boolean[n+1];
            boolean next = false;
            int first = 0;
            int second = 0;
            for (int j = 1; j <= n; j++){
                if (visited[j]) continue;
                if (next) {
                    second = bfs(graph, j);
                    continue;
                } 
                first = bfs(graph, j);
                next = true;
            }
            answer = Math.min(answer, Math.abs(first - second));
            
            status[i] = false;
        }
        
        return answer;
    }
    
    public static int bfs(ArrayList<Integer>[] graph, int start){
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        
        while (!q.isEmpty()){
            int temp = q.poll();
            for (Integer next : graph[temp]){
                if (visited[next]) continue;
                visited[next] = true;
                q.offer(next);
                count++;
            }
        }
        return count;
    }
}