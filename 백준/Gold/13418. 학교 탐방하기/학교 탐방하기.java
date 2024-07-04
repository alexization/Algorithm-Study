import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<int[]>[] g = new List[N+1];
		for (int i = 0; i <= N; i++) g[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int temp = Integer.parseInt(st.nextToken());
		if (temp == 0) temp = 1;
		else temp = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (c == 0) c = 1;
			else c = 0;
			g[a].add(new int[] {b, c});
			g[b].add(new int[] {a, c});
		}
		
		boolean[] v = new boolean[N+1];
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		int sum = 0, cnt = 0;
		
		q.offer(new int[] {1, temp});
		while (!q.isEmpty()) {
			int[] vc = q.poll();
			int min = vc[1];
			int minVertex = vc[0];
			if (v[minVertex]) continue;
			
			v[minVertex] = true;
			sum += min;
			if (cnt++ == N) break;
			
			for (int[] j : g[minVertex]) {
				if (!v[j[0]]) q.offer(j);
			}
		}
		
		v = new boolean[N+1];
		
		PriorityQueue<int[]> maxQ = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1[1], o2[1]));
		
		int maxSum = 0;
		cnt = 0;
		
		maxQ.offer(new int[] {1, temp});
		while (!maxQ.isEmpty()) {
			int[] vc = maxQ.poll();
			int min = vc[1];
			int minVertex = vc[0];
			if (v[minVertex]) continue;
			
			v[minVertex] = true;
			maxSum += min;
			if (cnt++ == N) break;
			
			for (int[] j : g[minVertex]) {
				if (!v[j[0]]) maxQ.offer(j);
			}
		}
		
		maxSum *= maxSum;
		sum *= sum;
		System.out.println(maxSum - sum);
		br.close();
	}
}