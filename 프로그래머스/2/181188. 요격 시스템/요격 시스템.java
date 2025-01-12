import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] targets) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < targets.length; i++){
            queue.offer(targets[i]);
        }
        
        int[] temp = queue.poll();
        int end = temp[1];
        
        int count = 1;
        while(!queue.isEmpty()){
            temp = queue.poll();
            
            if (end <= temp[0]){
                count++;
                end = temp[1];
            }
        }
        
        return count;
    }
}