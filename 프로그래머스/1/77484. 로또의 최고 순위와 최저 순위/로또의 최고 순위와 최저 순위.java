class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int maxValue = 0;
        int minValue = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                maxValue++;
                continue;
            }
            for (int winNum : win_nums) {
                if (lotto == winNum) {
                    maxValue++;
                    minValue++;
                    break;
                }
            }
        }
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        int[] answer = {rank[maxValue], rank[minValue]};
        return answer;
    }
}