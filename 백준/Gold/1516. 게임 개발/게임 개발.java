import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i < N; i++) g.add(new ArrayList<>());
		
		int[] times = new int[N];
		int[] indegree = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			times[i] = time;
			
			while (st.hasMoreTokens()) {
				int next = Integer.parseInt(st.nextToken());
				if (next == -1) break;
				g.get(next - 1).add(i);
				indegree[i]++;
			}
		}
		
		int[] dp = new int[N];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < N ; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
				dp[i] = times[i];
			}
		}
		
		while (!q.isEmpty()) {
			int idx = q.poll();
			for (Integer temp : g.get(idx)) {
				dp[temp] = Math.max(dp[temp], dp[idx] + times[temp]);
				if (--indegree[temp] == 0) q.offer(temp);
			}
		}
		
		for (int result : dp) System.out.println(result);
		br.close();
	}
}