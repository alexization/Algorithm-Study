import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        String str = br.readLine();
        List<Integer> list = new ArrayList<>();

        char c = str.charAt(0);
        int count = 0;
        for (int i = 0; i < K; i++) {
            if (c == str.charAt(i)) {
                count++;
            } else {
                list.add(count);
                c = str.charAt(i);
                count = 1;
            }
        }

        list.add(count);

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            maxValue = Math.max(maxValue, Math.min(list.get(i), list.get(i + 1)));
        }
        if (maxValue == Integer.MIN_VALUE) System.out.println(0);
        else System.out.println(maxValue * 2);
        br.close();
    }
}
