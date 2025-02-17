import java.io.*;
import java.util.*;

class Solution {
    
    static ArrayList<int[]> checkCode = new ArrayList<>();
    static ArrayList<int[]> possibleCode = new ArrayList<>();
    static int answer = 0;
    static int N;
    static int[][] Q;
    
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        Q = q;
        
        makeCode(1, 0, new int[5]);
        check(ans);
        
        return answer;
    }
    
    private static void makeCode(int start, int index, int[] arr){
        if (index == 5){
            checkCode.add(arr.clone());
            return;
        }
        
        for (int i = start; i <= N; i++){
            arr[index] = i;
            makeCode(i + 1, index + 1, arr);
        }
    }
    
    private static void check(int[] ans){
        for (int i = 0; i < checkCode.size(); i++){
            boolean isPossible = true;
            for (int j = 0; j < Q.length; j++){
                if (!match(checkCode.get(i), Q[j], ans[j])){
                    isPossible = false;
                    break;
                }
            }
            if (isPossible){
                answer++;
            }
        }
    }
    
    private static boolean match(int[] a, int[] b, int ans){
        int count = 0;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if (a[i] == b[j]) count++;
            }
        }

        if (count == ans) return true;
        return false;
    }
}