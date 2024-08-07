import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] visited, already;
    static int count;

    static void dfs(int idx) {
        if (already[idx]) {
            return;
        }
        if (visited[idx]) {
            already[idx] = true;
            count++;
        }
        visited[idx] = true;
        dfs(arr[idx]);
        already[idx] = true;
        visited[idx] = false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            count = 0;
            visited = new boolean[N + 1];
            already = new boolean[N + 1];
            for (int j = 1; j <= N ; j++) {
                if (!already[j]) {
                    dfs(j);
                }
            }
            System.out.println(N - count);
        }

        br.close();
    }
}
