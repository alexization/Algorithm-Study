import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long minResult = Long.MAX_VALUE;
        long minValue = 0, maxValue = 0;
        for (int i = 0; i < N - 1; i++) {
            int start = i + 1;
            int end = N - 1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                long sumValue = Math.abs(arr[i] + arr[mid]);
                if (minResult > sumValue) {
                    minResult = sumValue;
                    minValue = arr[i];
                    maxValue = arr[mid];
                }
                if (arr[mid] >= -arr[i]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        System.out.println(minValue + " " + maxValue);
        br.close();
    }
}
