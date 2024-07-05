import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] lose = new int[N+1];
		int[] gain = new int[N+1];
		int[][] dp = new int[N+1][100];
		
		for (int i = 1; i < N + 1; i++) lose[i] = sc.nextInt();
		for (int i = 1; i < N + 1; i++) gain[i] = sc.nextInt();
		
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < 100; j++) {
				if (lose[i] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - lose[i]] + gain[i]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][99]);
		sc.close();
	}
}