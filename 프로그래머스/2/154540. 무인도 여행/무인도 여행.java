import java.util.*;
import java.io.*;

class Solution {
    public static boolean[][] visited;
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> result = new ArrayList<>();
        
        visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++){
            for (int j = 0; j < maps[0].length(); j++){
                if (maps[i].charAt(j) != 'X' && !visited[i][j]){
                    int value = sumFoods(maps, i, j);
                    result.add(value);
                }
            }
        }
        
        int[] answer = {};
        if (result.isEmpty()){
            answer = new int[]{-1};
        }
        else {
            answer = new int[result.size()];
        
            for (int i = 0; i < result.size(); i++){
                answer[i] = result.get(i).intValue();
            }
            Arrays.sort(answer);
        }

        return answer;
    }
    
    public static int sumFoods(String[] maps, int x, int y){
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        int sumFoods = 0;
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            sumFoods += (maps[temp[0]].charAt(temp[1]) - '0');
            
            for (int i = 0; i < 4; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length()){
                    continue;
                }
                if (maps[nx].charAt(ny) == 'X' || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
        return sumFoods;
    }
}