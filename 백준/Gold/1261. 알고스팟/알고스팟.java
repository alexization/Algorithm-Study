import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] g = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				g[i][j] = (int) (str.charAt(j) - '0');
			}
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		boolean[][] v = new boolean[N][M];
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		q.offer(new int[] {0, 0, 0});
		v[0][0] = true;
		
		int result = -1;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			if (temp[0] == N-1 && temp[1] == M-1) {
				result = temp[2];
			}
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (v[nx][ny]) continue;
					v[nx][ny] = true;
					if (g[nx][ny] == 1) q.offer(new int[] {nx, ny, temp[2]+1});
					else q.offer(new int[] {nx, ny, temp[2]});
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}
}