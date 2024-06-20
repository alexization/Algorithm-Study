import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;

    static double avg(){

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        return (double) sum / N;
    }

    static int mid(){
        return arr[N/2];
    }

    static int maxCount(){
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            if (countMap.containsKey(arr[i])){
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            } else {
                countMap.put(arr[i], 1);
            }
        }


        int maxValue = -1;
        List<Integer> temp = new ArrayList<>();
        for (int key:countMap.keySet()){
            if (maxValue < countMap.get(key)){
                maxValue = countMap.get(key);
                temp.clear();
                temp.add(key);
            } else if (maxValue == countMap.get(key)) {
                temp.add(key);
            }
        }
        if (temp.size() == 1) return temp.get(0);
        else {
            int[] tempArr = new int[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                tempArr[i] = temp.get(i);
            }
            Arrays.sort(tempArr);
            return tempArr[1];
        }
    }

    static int range(){
        int minValue = arr[0];
        int maxValue = arr[N-1];
        return Math.abs(maxValue - minValue);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(Math.round(avg()));
        System.out.println(mid());
        System.out.println(maxCount());
        System.out.println(range());
        br.close();
    }
}
