import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Integer> nameToIndex = new HashMap<>();
        Map<Integer, String> indexToName = new HashMap<>();
        Map<String, int[]> giftMap = new HashMap<>();
        
        int size = friends.length;
        //giftMap index -> 준 선물, 받은 선물, 다음달에 받을 선물 개수
        for (int i = 0; i < size; i++){
            nameToIndex.put(friends[i], i);
            indexToName.put(i, friends[i]);
            giftMap.put(friends[i], new int[]{0, 0, 0});
        }
        
        int[][] giftTable = new int[size][size];
        
        for (String gift : gifts){
            StringTokenizer st = new StringTokenizer(gift, " ");
            String from = st.nextToken();
            String to = st.nextToken();
            
            int x = nameToIndex.get(from);
            int y = nameToIndex.get(to);
            
            giftTable[x][y] += 1;
            
            int[] fromValue = giftMap.get(from);
            fromValue[0] += 1;
            int[] toValue = giftMap.get(to);
            toValue[1] += 1;
            
            giftMap.put(from, fromValue);
            giftMap.put(to, toValue);
        }
        
        for (int i = 0; i < size; i++){
            for (int j = i + 1; j < size; j++){
                String from = indexToName.get(i);
                String to = indexToName.get(j);
                if (giftTable[i][j] > giftTable[j][i]){
                    int[] temp = giftMap.get(from);
                    temp[2] += 1;
                    giftMap.put(from, temp);
                } else if (giftTable[i][j] < giftTable[j][i]){
                    int[] temp = giftMap.get(to);
                    temp[2] += 1;
                    giftMap.put(to, temp);
                } else {
                    int[] fromValue = giftMap.get(from);
                    int[] toValue = giftMap.get(to);
                    if (fromValue[0] - fromValue[1] > toValue[0] - toValue[1]){
                        fromValue[2] += 1;
                        giftMap.put(from, fromValue);
                    } else if (fromValue[0] - fromValue[1] < toValue[0] - toValue[1]){
                        toValue[2] += 1;
                        giftMap.put(to, toValue);
                    }
                }
            }
        }
        
        int maxValue = -1;
        for (String name : giftMap.keySet()){
            maxValue = Math.max(maxValue, giftMap.get(name)[2]);
        }
        return maxValue;
    }
}