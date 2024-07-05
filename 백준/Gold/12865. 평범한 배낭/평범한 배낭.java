import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[K+1];
		
		int[] weights = new int[N+1];
		int[] values = new int[N+1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <N+1 ; i++) {
			for (int j = K; j > 0; j--) {
				if (weights[i] <= j) {
					dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
				} else {
					dp[j] = dp[j];
				}
			}
		}
		
		System.out.println(dp[K]);
		br.close();
	}
}