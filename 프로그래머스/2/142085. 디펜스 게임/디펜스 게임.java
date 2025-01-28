import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int stage = 0;
        for (int i = 0; i < enemy.length; i++){
            if (k > 0) {
                pq.offer(enemy[i]);
                k--;
                stage++;
                continue;
            }
            
            int e = enemy[i];
            if (pq.peek() < enemy[i]){
                e = pq.poll();
                pq.offer(enemy[i]);
            }
            
            if (n < e){
                break;
            }
            n -= e;
            stage++;
        }
        
        return stage;
    }
}