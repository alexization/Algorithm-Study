import java.io.*;
import java.util.*;

public class Main {
	
	static int[] p;
	
	static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		p[aRoot] = bRoot;
		return true;
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] graph = new int[E][3];
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			graph[i] = new int[] {a, b, cost};
		}
		
		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		p = new int[V + 1];
		for (int i = 0; i <= V; i++) p[i] = i;
		
		int sum = 0, cnt = 0;
		for (int[] e : graph) {
			if (union(e[0], e[1])) {
				sum += e[2];
				if (++cnt == V-1) break;
			}
		}
		
		System.out.println(sum);
		sc.close();
	}
}