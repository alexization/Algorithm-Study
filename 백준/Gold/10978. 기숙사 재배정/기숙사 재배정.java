import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] students = new int[t];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < t; i++) {
            students[i] = Integer.parseInt(br.readLine());
            maxValue = Math.max(maxValue, students[i]);
        }

        long[] dp = new long[maxValue + 1];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= maxValue; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
        }

        StringBuilder sb = new StringBuilder();
        for (int student : students) {
            if (student == 1) {
                sb.append(0 + "").append("\n");
            } else if (student == 2) {
                sb.append(1 + "").append("\n");
            } else {
                sb.append(dp[student]).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

}