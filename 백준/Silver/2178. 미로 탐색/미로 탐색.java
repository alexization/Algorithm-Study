import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void bfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int[] temp = new int[2];
        while (!q.isEmpty()) {
            temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (graph[nx][ny] == 0) continue;
                    if (visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    graph[nx][ny] = graph[temp[0]][temp[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = (int) row.charAt(j) - 48;
            }
        }

        bfs();
        System.out.println(graph[N-1][M-1]);
        
        br.close();
    }
}