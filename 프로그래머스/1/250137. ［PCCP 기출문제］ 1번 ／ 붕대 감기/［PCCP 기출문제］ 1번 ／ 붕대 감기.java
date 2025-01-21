class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {     
        int nowHealth = health;
        int[] firstHit = attacks[0];
        
        int lastHitTime = firstHit[0];
        nowHealth -= firstHit[1];
        
        for (int i = 1; i < attacks.length; i++){
            int[] hit = attacks[i];
            int time = hit[0] - lastHitTime;
            nowHealth += heal(time - 1, bandage);
            if (nowHealth > health){
                nowHealth = health;
            }
            
            nowHealth -= hit[1];
            lastHitTime = hit[0];
            
            if (nowHealth <= 0){
                break;
            }
        }
        
        if (nowHealth <= 0) {
            return -1;
        } else {
            return nowHealth;   
        }
    }
    
    public static int heal(int time, int[] bandage){
        int successCount = time / bandage[0];

        return successCount * bandage[2] + time * bandage[1];
    }
}