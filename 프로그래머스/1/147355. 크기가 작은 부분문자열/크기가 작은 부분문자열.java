class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int pLen = p.length();
        Long pNum = Long.parseLong(p);
        
        for (int i = 0; i <= t.length() - pLen; i++){
            Long tNum = Long.parseLong(t.substring(i, i+pLen));
            if (tNum <= pNum) answer++;
        }
        
        return answer;
    }
}