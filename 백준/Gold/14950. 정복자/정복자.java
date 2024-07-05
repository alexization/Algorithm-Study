import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		List<int[]>[] g = new List[N+1];
		for (int i = 0; i < N + 1 ; i++) g[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g[a].add(new int[] {b, cost});
			g[b].add(new int[] {a, cost});
		}
		
		boolean[] v = new boolean[N+1];
		int[] w = new int[N+1];
		Arrays.fill(w, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		w[1] = 0;
		q.offer(new int[] {1, 0});
		int sum = 0, cnt = 0;
		while (!q.isEmpty()) {
			int[] vc = q.poll();
			int min = vc[1];
			int minVertex = vc[0];
			
			if(v[minVertex]) continue;
			v[minVertex] = true;
			
			if (cnt != 0) sum += ((cnt - 1) * T) + min;
			if (cnt++ == N-1) break;
			
			for (int[] j : g[minVertex]) {
				if (!v[j[0]] && w[j[0]] > j[1]) {
					w[j[0]] = j[1];
					q.offer(new int[] {j[0], w[j[0]]});
				}
			}
		}
		
		System.out.println(sum);
		br.close();
	}
}