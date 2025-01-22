import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        
        int sx = -1;
        int sy = -1;
        int ex = -1;
        int ey = -1;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R'){
                    sx = i;
                    sy = j;
                }
                if (board[i].charAt(j) == 'G'){
                    ex = i;
                    ey = j;
                }
            }
        }
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        boolean[][] visited = new boolean[board.length][board[0].length()];
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        queue.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if (board[temp[0]].charAt(temp[1]) == 'G'){
                answer = temp[2];
                break;
            }
            
            for (int i = 0; i < 4; i++){
                int x = temp[0];
                int y = temp[1];
                
                while (true){
                    x += dx[i];
                    y += dy[i];
                    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length()){
                        if (visited[x - dx[i]][y - dy[i]]){
                            break;
                        }
                        queue.offer(new int[]{x - dx[i], y - dy[i], temp[2] + 1});
                        visited[x - dx[i]][y - dy[i]] = true;
                        break;
                    }
                    if (board[x].charAt(y) == 'D') {
                        if (visited[x - dx[i]][y - dy[i]]){
                            break;
                        }
                        queue.offer(new int[]{x - dx[i], y - dy[i], temp[2] + 1});
                        visited[x - dx[i]][y - dy[i]] = true;
                        break;
                    }
                }
            }
        }
        if (answer == 0) return -1;
        else return answer;
    }
}