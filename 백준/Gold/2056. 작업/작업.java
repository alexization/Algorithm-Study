import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i < N; i++) g.add(new ArrayList<>());
		
		int[] times = new int[N];
		int[] indegree = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			times[i] = time;
			
			int id = Integer.parseInt(st.nextToken());
			indegree[i] = id;
			for (int j = 0; j < id; j++) {
				int value = Integer.parseInt(st.nextToken());
				g.get(value-1).add(i);
			}
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int[] timeDP = new int[N];
		for (int i = 0; i < N; i++) {
			if (indegree[i] == 0) {
				timeDP[i] = times[i];
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int idx = q.poll();
			for (Integer temp : g.get(idx)) {
				timeDP[temp] = Math.max(timeDP[temp], timeDP[idx] + times[temp]);
				if (--indegree[temp] == 0) {
					q.offer(temp);
				}
			}
		}
		int maxTime = 0;
		for (int i = 0; i < N; i++) {
			maxTime = Math.max(maxTime, timeDP[i]);
		}
		System.out.println(maxTime);
		br.close();
	}
}