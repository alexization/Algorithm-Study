import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        Deque<int[]> dq = new LinkedList<>();
        dq.offer(new int[]{0, 0});

        int[][] broken = new int[n][m];
        for (int[] b : broken) {
            Arrays.fill(b, -1);
        }
        broken[0][0] = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        while (!dq.isEmpty()) {
            int[] temp = dq.poll();
            int x = temp[0];
            int y = temp[1];
            if (x == n && y == m) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (broken[nx][ny] != -1) continue;
                if (graph[nx][ny] == '1') {
                    broken[nx][ny] = broken[x][y] + 1;
                    dq.offer(new int[]{nx, ny});
                } else {
                    broken[nx][ny] = broken[x][y];
                    dq.addFirst(new int[]{nx, ny});
                }
            }
        }

        System.out.println(broken[n - 1][m - 1]);
        br.close();
    }

}