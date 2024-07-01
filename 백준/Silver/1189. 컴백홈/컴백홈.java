import java.io.*;
import java.util.*;

public class Main {

    static int R, C, K, result = 0;
    static char[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void dfs(int x, int y, int count, boolean[][] visit){
        if (x == 0 && y == C - 1 && count == K) {
            result++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (graph[nx][ny] != 'T'){
                    if (visit[nx][ny]) continue;
                    visit[nx][ny] = true;
                    dfs(nx, ny, count+1, visit);
                    visit[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = row.charAt(j);
            }
        }

        boolean[][] visited = new boolean[R][C];
        visited[R-1][0] = true;
        dfs(R-1, 0, 1, visited);
        System.out.println(result);
        br.close();
    }
}