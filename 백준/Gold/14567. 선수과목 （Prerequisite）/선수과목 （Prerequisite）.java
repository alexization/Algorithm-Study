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
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g.get(a).add(b);
			indegree[b]++;
		}
		
		
		int[] result = new int[N+1];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i < N+1; i++) {
			if (indegree[i] == 0) {
				result[i] = 1;
				q.offer(i);
			}
			
		}
		
		while (!q.isEmpty()) {
			int idx = q.poll();
			for (Integer temp : g.get(idx)) {
				if (--indegree[temp] == 0) {
					result[temp] = result[idx] + 1;
					q.offer(temp);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) System.out.print(result[i] + " ");
		br.close();
	}
}