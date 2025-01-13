import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int sx = -1;
        int sy = -1;
        boolean status = false;
        for (int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length(); j++){
                if (park[i].charAt(j) == 'S'){
                    sx = i;
                    sy = j;
                    status = true;
                    break;
                }
            }
            if (status) break;
        }
        
        Map<String, int[]> dir = new HashMap<>();
        dir.put("E", new int[]{0, 1});
        dir.put("N", new int[]{-1, 0});
        dir.put("S", new int[]{1, 0});
        dir.put("W", new int[]{0, -1});
        
        for(String route : routes){
            StringTokenizer st = new StringTokenizer(route, " ");
            String op = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            
            int[] direction = dir.get(op);
            boolean isAvailable = true;
            
            int nx = sx;
            int ny = sy;
            for (int i = 0; i < n; i++){
                nx += direction[0];
                ny += direction[1];
                if (nx < 0 || ny < 0 || nx >= park.length || ny >= park[0].length()){
                    isAvailable = false;
                    break;
                }
                if (park[nx].charAt(ny) == 'X'){
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable){
                sx = nx;
                sy = ny;
            }
        }
        
        answer[0] = sx;
        answer[1] = sy;
        return answer;
    }
}