class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 1;
        int range = section[0] + m;
        boolean status = false;
        for (int sec : section){
            if (status) break;
            if (range - 1 < sec){
                range = sec + m;
                count++;
                if (range > n){
                    status = true;
                }
            }
        }
        
        return count;
    }
}