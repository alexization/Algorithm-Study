import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int minValue = Integer.MAX_VALUE;
	static int[][] g;
	static boolean[][] v;
	static ArrayList<int[]> virus = new ArrayList<>();
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static void dfs(int depth) {
		if (depth == 3) {
			v = new boolean[N][M];
			int value = 0;
			for (int[] pos : virus) {
				if (v[pos[0]][pos[1]] == false) {
					value += go(pos[0], pos[1]);
				}
			}
			minValue = Math.min(minValue, value);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (g[i][j] == 0) {
					g[i][j] = 1;
					dfs(depth+1);
					g[i][j] = 0;
				}
			}
		}
	}
	
	static int go(int x, int y) {
		
		int count = 1;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (v[nx][ny]) continue;
					if (g[nx][ny] == 0) {
						v[nx][ny] = true;
						count++;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new int[N][M];
		
		int total = N * M;
		int wall = 3;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				g[i][j] = value;
				if (value == 1) wall++;
				else if (value == 2) virus.add(new int[] {i, j});
			}
		}
		
		dfs(0);
		System.out.println(total - wall - minValue);
		br.close();
	}
}