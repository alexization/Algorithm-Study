import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> -(o2[2] - o1[2]));
        boolean[][] visited = new boolean[N][N];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        q.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        int result = 0;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            if (x == N - 1 && y == N - 1) {
                result = temp[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    if (graph[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny, temp[2] + 1});
                    } else {
                        q.offer(new int[]{nx, ny, temp[2]});
                    }
                }
            }
        }

        System.out.println(result);
        br.close();
    }
}