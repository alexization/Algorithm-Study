import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        String lowerStr = s.toLowerCase();
        int pCnt = 0;
        int yCnt = 0;
        for (int i = 0; i < lowerStr.length(); i++){
            if (lowerStr.charAt(i) == 'p') pCnt++;
            else if (lowerStr.charAt(i) == 'y') yCnt++;
        }

        if (pCnt == yCnt) return true;
        else return false;

    }
}