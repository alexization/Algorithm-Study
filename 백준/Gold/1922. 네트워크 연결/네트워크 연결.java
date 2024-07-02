import java.util.*;
import java.io.*;

public class Main {
	
	static int[] parent;
	
	static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		parent[aRoot] = bRoot;
		return true;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[M][3];
		for (int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[i] = new int[] {a, b, cost};
		}
		
		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) parent[i] = i;
		
		int result = 0, cnt = 0;
		for (int[] e : graph) {
			if (union(e[0], e[1])) {
				result += e[2];
				if (++cnt == N - 1) break;
			}
		}
		
		System.out.println(result);
		br.close();
	}
}