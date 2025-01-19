class Solution {
    public int solution(int[] numbers) {
        boolean[] find = new boolean[10];
        for (int number : numbers) {
            find[number] = true;
        }
        
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            if (!find[i]) answer += i;
        }
        return answer;
    }
}