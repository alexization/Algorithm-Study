import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sx = -1;
        int sy = -1;

        char[][] graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            String raw = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = raw.charAt(j);
                if (graph[i][j] == 'I') {
                    sx = i;
                    sy = j;
                }
            }
        }

        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { 1, -1, 0, 0 };

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        queue.offer(new int[] { sx, sy });
        visited[sx][sy] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= N || ny >= M || nx < 0 || ny < 0) continue;
                if (visited[nx][ny] || graph[nx][ny] == 'X') continue;

                if (graph[nx][ny] == 'P') result++;
                visited[nx][ny] = true;
                queue.offer(new int[] { nx, ny });
            }
        }

        System.out.println(result == 0 ? "TT" : result);
    }
}
