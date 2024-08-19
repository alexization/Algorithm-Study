import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, arr[0], 0});
        visited[0] = true;

        int result = -1;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int idx = temp[0];
            if (temp[0] == N - 1) result = temp[2];
            if (temp[1] == 0) continue;
            for (int i = 1; i <= temp[1]; i++) {
                if (idx + i >= N) continue;
                if (!visited[idx + i]) {
                    visited[idx + i] = true;
                    q.offer(new int[]{idx + i, arr[idx + i], temp[2] + 1});
                }
            }
        }

        System.out.println(result);
        br.close();
    }
}
