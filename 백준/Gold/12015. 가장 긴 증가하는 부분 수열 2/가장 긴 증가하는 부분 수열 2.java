import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(arr[0]);
        for (int i = 1; i < N; i++) {
            if (dp.get(dp.size() - 1) < arr[i]) {
                dp.add(arr[i]);
            } else {
                int start = 0;
                int end = dp.size() - 1;
                while (start < end) {
                    int mid = (start + end) >>> 1;
                    if (dp.get(mid) < arr[i]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                dp.set(start, arr[i]);
            }
        }

        System.out.println(dp.size());
        br.close();
    }
}
