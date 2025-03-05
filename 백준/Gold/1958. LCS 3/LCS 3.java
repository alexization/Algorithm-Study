import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] firstArr = br.readLine().toCharArray();
        char[] secondArr = br.readLine().toCharArray();
        char[] thirdArr = br.readLine().toCharArray();

        int firstLength = firstArr.length;
        int secondLength = secondArr.length;
        int thirdLength = thirdArr.length;

        int[][][] dp = new int[firstLength + 1][secondLength + 1][thirdLength + 1];
        for (int i = 1; i < firstLength + 1; i++) {
            for (int j = 1; j < secondLength + 1; j++) {
                for (int k = 1; k < thirdLength + 1; k++) {
                    if (firstArr[i - 1] == secondArr[j - 1] && secondArr[j - 1] == thirdArr[k - 1]) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }

        System.out.println(dp[firstLength][secondLength][thirdLength]);
        br.close();
    }
}