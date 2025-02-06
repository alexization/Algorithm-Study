import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> firstQ = new LinkedList<>();
        Queue<String> secondQ = new LinkedList<>();
        
        for (String card1 : cards1) firstQ.offer(card1);
        for (String card2 : cards2) secondQ.offer(card2);
        
        boolean isYes = true;
        for(int i = 0; i < goal.length; i++){
            if (!firstQ.isEmpty() && firstQ.peek().equals(goal[i])) {
                firstQ.poll();
                continue;
            } else if (!secondQ.isEmpty() && secondQ.peek().equals(goal[i])) {
                secondQ.poll();
                continue;
            }
            isYes = false;
            break;
        }
        
        if (isYes) return "Yes";
        return "No";
    }
}