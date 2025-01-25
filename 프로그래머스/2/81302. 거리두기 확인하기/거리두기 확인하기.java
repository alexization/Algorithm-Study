class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        int index = 0;
        for (String[] place : places) {
            
            boolean status = true;
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                    if (place[i].charAt(j) == 'P'){
                        if (!check(i, j, place)){
                            status = false;
                            break;
                        }
                    }
                }
                if (!status) break;
            }
            if (status) answer[index++] = 1;
            else answer[index++] = 0;
        }
        
        return answer;
    }
    
    public static boolean check(int x, int y, String[] place){
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        
        for (int i = 0; i < 2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 5 || ny >= 5){
                continue;
            }
            if (place[nx].charAt(ny) == 'P'){
                return false;
            }
        }
        
        if (x > 0 && y < 4){
            if (place[x-1].charAt(y+1) == 'P'){
                if (place[x].charAt(y+1) != 'X' || place[x-1].charAt(y) != 'X'){
                    return false;
                }
            }
        }
        
        if (x < 4 && y < 4){
            if (place[x+1].charAt(y+1) == 'P'){
                if (place[x].charAt(y+1) != 'X' || place[x+1].charAt(y) != 'X'){
                    return false;
                }
            }
        }
        
        if (x < 3 && y < 5){
            if (place[x+2].charAt(y) == 'P'){
                if (place[x+1].charAt(y) != 'X'){
                    return false;
                }
            }
        }
        
        if (x < 5 && y < 3){
            if (place[x].charAt(y+2) == 'P'){
                if (place[x].charAt(y+1) != 'X'){
                    return false;
                }
            }
        }
            
        return true;
    }
}