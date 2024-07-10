import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i < N+1; i++) g.add(new ArrayList<>());
		
		int[] indegree = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(st.nextToken());
			if (count == 1) continue;
			int from = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count - 1; j++) {
				int to = Integer.parseInt(st.nextToken());
				g.get(from).add(to);
				indegree[to]++;
				from = to;
			}
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i < N+1; i++) {
			if (indegree[i] == 0) q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int idx = q.poll();
			sb.append(idx).append("\n");
			for (Integer temp : g.get(idx)) {
				if (--indegree[temp] == 0) {
					q.offer(temp);
				}
			}
		}
		
		boolean status = true;
		for (int i = 1; i < N+1; i++) {
			if (indegree[i] != 0) {
				status = false;
				break;
			}
		}
		if (status) System.out.println(sb);
		else System.out.println(0);
		br.close();
	}
}