import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] times = new int[N + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; j++) times[j] = Integer.parseInt(st.nextToken());
			
			int[] indegree = new int[N + 1];
			List<ArrayList<Integer>> g = new ArrayList<>();
			for (int j = 0 ; j < N + 1; j++) g.add(new ArrayList<>());
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				g.get(a).add(b);
				indegree[b]++;
			}
			
			int w = Integer.parseInt(br.readLine());
			
			int[] dp = new int[N+1];
			
			ArrayDeque<Integer> q = new ArrayDeque<>();
			for (int j = 1; j < N+1; j++) {
				if (indegree[j] == 0) {
					dp[j] = times[j];
					q.offer(j);
				}
			}
			
			while (!q.isEmpty()) {
				int idx = q.poll();
				for (Integer temp : g.get(idx)) {
					dp[temp] = Math.max(dp[temp], dp[idx] + times[temp]);
					if (--indegree[temp] == 0) q.offer(temp);
				}
			}
			System.out.println(dp[w]);
		}
		br.close();
	}
}