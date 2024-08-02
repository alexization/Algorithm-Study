import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(br.readLine());
                if (!map.containsKey(value)) {
                    map.put(value, 1);
                } else {
                    map.put(value, map.get(value) + 1);
                }
            }
            int minValue = Integer.MAX_VALUE;
            int maxCount = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (maxCount < entry.getValue()) {
                    maxCount = entry.getValue();
                    minValue = entry.getKey();
                } else if (maxCount == entry.getValue() && entry.getKey() < minValue) {
                    minValue = entry.getKey();
                }
            }
            System.out.println(minValue);
        }
        br.close();
    }
}
