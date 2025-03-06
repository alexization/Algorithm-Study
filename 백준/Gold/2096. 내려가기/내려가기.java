import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] maxDP = new int[n][3];
        int[][] minDP = new int[n][3];

        for (int i = 0; i < 3; i++) {
            maxDP[0][i] = graph[0][i];
            minDP[0][i] = graph[0][i];
        }

        for (int i = 1; i < n; i++) {
            maxDP[i][0] = Math.max(maxDP[i - 1][0], maxDP[i - 1][1]) + graph[i][0];
            minDP[i][0] = Math.min(minDP[i - 1][0], minDP[i - 1][1]) + graph[i][0];

            maxDP[i][1] = Math.max(maxDP[i - 1][0], Math.max(maxDP[i - 1][1], maxDP[i - 1][2])) + graph[i][1];
            minDP[i][1] = Math.min(minDP[i - 1][0], Math.min(minDP[i - 1][1], minDP[i - 1][2])) + graph[i][1];

            maxDP[i][2] = Math.max(maxDP[i - 1][1], maxDP[i - 1][2]) + graph[i][2];
            minDP[i][2] = Math.min(minDP[i - 1][1], minDP[i - 1][2]) + graph[i][2];
        }

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            maxValue = Math.max(maxValue, maxDP[n - 1][i]);
            minValue = Math.min(minValue, minDP[n - 1][i]);
        }

        System.out.println(maxValue + " " + minValue);
        br.close();
    }
}