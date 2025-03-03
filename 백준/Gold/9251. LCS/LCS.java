import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] firstArr = br.readLine().toCharArray();
        char[] secondArr = br.readLine().toCharArray();

        int[][] dp = new int[firstArr.length + 1][secondArr.length + 1];

        for (int i = 1; i <= firstArr.length; i++) {
            for (int j = 1; j <= secondArr.length; j++) {
                if (firstArr[i - 1] == secondArr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[firstArr.length][secondArr.length]);
        br.close();
    }
}