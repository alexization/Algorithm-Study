import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<int[]>[] g = new List[N+1]; for (int i = 0; i <= N; i++) g[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g[a].add(new int[] {b, cost});
			g[b].add(new int[] {a, cost});
		}
		
		boolean[] v = new boolean[N+1];
		int[] w = new int[N+1];
		for (int i = 0; i <= N; i++) w[i] = Integer.MAX_VALUE;
		
		int sum = 0, cnt = 0;
		w[1] = 0;
		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int j = 1; j <= N; j++) {
				if (!v[j] && min > w[j]) {
					min = w[j];
					minVertex = j;
				}
			}
			
			v[minVertex] = true;
			sum += min;
			if (cnt++ == N-1) break;
			
			for (int[] j : g[minVertex]) {
				if (!v[j[0]] && w[j[0]] > j[1]) {
					w[j[0]] = j[1];
				}
			}
		}
		
		System.out.println(sum);
		br.close();
	}
}