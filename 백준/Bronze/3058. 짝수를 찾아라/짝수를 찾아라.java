import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] arr = new int[7];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < 7; j++) {
                if (arr[j] % 2 == 0) {
                    sum += arr[j];
                    minValue = Math.min(minValue, arr[j]);
                }
            }

            System.out.println(sum + " " + minValue);
        }
        br.close();
    }
}
