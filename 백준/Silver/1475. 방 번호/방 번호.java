import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - '0';
            if (value == 6) value = 9;
            map.put(value, map.get(value) + 1);
        }

        int temp = map.get(9);
        if (temp % 2 == 0) temp = temp / 2;
        else temp = temp / 2 + 1;
        map.put(9, temp);

        int maxValue = Integer.MIN_VALUE;
        for (Integer value : map.values()) {
            maxValue = Math.max(maxValue, value);
        }

        System.out.println(maxValue);
        br.close();
    }
}
