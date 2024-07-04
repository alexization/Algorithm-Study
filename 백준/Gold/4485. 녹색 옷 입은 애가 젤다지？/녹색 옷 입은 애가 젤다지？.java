import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = {-1, 0 ,1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			int[][] g = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					g[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean[][] v = new boolean[N][N];
			
			PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
			int cost = g[0][0];
			q.offer(new int[] {0, 0, cost});
			v[0][0] = true;
			
			int minValue = Integer.MAX_VALUE;
			while (!q.isEmpty()) {
				int[] temp = q.poll();
				if (temp[0] == N-1 && temp[1] == N-1) {
					minValue = Math.min(minValue, temp[2]);
				}
				for (int i = 0; i < 4; i++) {
					int nx = temp[0] + dx[i];
					int ny = temp[1] + dy[i];
					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if (v[nx][ny]) continue;
						v[nx][ny] = true;
						q.offer(new int[] {nx, ny, temp[2] + g[nx][ny]});
					}
				}
			}
			System.out.print("Problem " + count++ + ": ");
			System.out.println(minValue);
		}
		br.close();
	}
}
