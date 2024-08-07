import java.io.*;
import java.util.*;

public class Main {
	static long INF = 999_990_000_1L;
	
	static class Node{
		int index;
		long cost;
		
		Node (int index, long cost){
			this.index = index;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		List<Node>[] g = new List[N];
		for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g[a].add(new Node(b, cost));
			g[b].add(new Node(a, cost));
		}
		
		boolean[] v = new boolean[N];
		long[] dist = new long[N];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
		q.offer(new Node(0, 0));
		dist[0] = 0;
		
		while (!q.isEmpty()) {
			Node vc = q.poll();
			int minVertex = vc.index;
			long min = vc.cost;
			
			if(v[minVertex]) continue;
			v[minVertex] = true;
			
			for (Node j : g[minVertex]) {
				if (!v[j.index] && dist[j.index] >  min + j.cost) {
					if (arr[j.index] == 0 || j.index == N-1) {
						dist[j.index] = min + j.cost;
						q.offer(new Node(j.index, dist[j.index]));
					}
				}
			}
		}
		if (dist[N-1] == INF) System.out.println(-1);
		else System.out.println(dist[N-1]);
		br.close();
	}
}