import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));

        br.close();
    }

    private static long solution(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        long[] dp = new long[n + 1];
        dp[1] = 0L;
        dp[2] = 1L;

        for (int i = 3; i <= n; i++) {
            dp[i] = ((i - 1) * (dp[i - 2] + dp[i - 1])) % 1_000_000_000;
        }

        return dp[n];
    }
}