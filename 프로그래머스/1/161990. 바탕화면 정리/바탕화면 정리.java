class Solution {
    public int[] solution(String[] wallpaper) { 
        int sx = Integer.MAX_VALUE;
        int sy = Integer.MAX_VALUE;
        int ex = Integer.MIN_VALUE;
        int ey = Integer.MIN_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++){
            for (int j = 0; j < wallpaper[0].length(); j++){
                if (wallpaper[i].charAt(j) == '#') {
                    sx = Math.min(sx, i);
                    sy = Math.min(sy, j);
                    ex = Math.max(ex, i + 1);
                    ey = Math.max(ey, j + 1);
                }        
            }
        }
        
        int[] answer = new int[]{sx, sy, ex, ey};
        return answer;
    }
}