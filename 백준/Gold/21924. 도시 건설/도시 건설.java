import java.util.*;
import java.io.*;

public class Main {

	static int[] p;
	
	static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB) return false;
		p[rootA] = rootB;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] g = new int[M][3];
		long total = 0;
		for (int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			total += c;
			g[i] = new int[] {a, b, c};
		}
		
		Arrays.sort(g, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		p = new int[N+1];
		for (int i = 0; i <= N; i++) p[i] = i;
		long sum = 0;
		int cnt = 0;
		boolean status = false;
		for (int[] e : g) {
			if (union(e[0], e[1])) {
				sum += e[2];
				if (++cnt == N-1) {
					status = true;
					break;
				}
			}
		}

		if (status) System.out.println(total - sum);
		else System.out.println(-1);
		br.close();
	}
}
