import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] graph;
    static boolean[][] possible, visited;
    static boolean status;
    static HashMap<Character, int[]> distMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        distMap.put('U', new int[]{-1, 0});
        distMap.put('D', new int[]{1, 0});
        distMap.put('L', new int[]{0, -1});
        distMap.put('R', new int[]{0, 1});

        possible = new boolean[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    status = false;
                    dfs(i, j, visited);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (possible[i][j]) answer++;
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        char cmd = graph[x][y];
        int[] dist = distMap.get(cmd);

        int nx = x + dist[0];
        int ny = y + dist[1];

        if (canMove(nx, ny)) {
            if (visited[nx][ny]) {
                if (possible[nx][ny]) {
                    possible[x][y] = true;
                    status = true;
                }
                return;
            }

            dfs(nx, ny, visited);

            if (status) {
                possible[x][y] = true;
            }

        } else {
            possible[x][y] = true;
            status = true;
        }
    }

    private static boolean canMove(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}