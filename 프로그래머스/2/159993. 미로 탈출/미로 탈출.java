import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] maps) {        
        int sx = -1;
        int sy = -1;
        int fx = -1;
        int fy = -1;
        
        for (int i = 0; i < maps.length; i++){
            for (int j = 0; j < maps[0].length(); j++){
                if (maps[i].charAt(j) == 'S'){
                    sx = i;
                    sy = j;
                } else if (maps[i].charAt(j) == 'E'){
                    fx = i;
                    fy = j;
                }
            }
        }
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        queue.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        int firstDist = -1;
        boolean status = false;
        int secondDist = -1;
        
        while(!queue.isEmpty()){
            
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int dist = temp[2];
            
            if (!status && maps[x].charAt(y) == 'L'){
                firstDist = dist;
                visited = new boolean[maps.length][maps[0].length()];
                queue.clear();
                queue.offer(new int[]{x, y, 0});
                visited[x][y] = true;
                status = true;
                continue;
            }
            
            if (status && maps[x].charAt(y) == 'E'){
                secondDist = dist;
                break;
            }
            
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length()){
                    continue;
                }
                if (maps[nx].charAt(ny) == 'X'){
                    continue;
                }
                if (visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }
        
        if (firstDist == -1 || secondDist == -1){
            return -1;
        }
        
        return firstDist + secondDist;
    }
}