import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][][] g = new int[K + 1][N][M];
        int[][][] v = new int[K + 1][N][M];
        for (int i = 0; i < K + 1; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    v[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int value = (int) str.charAt(j) - '0';
                for (int k = 0; k < K + 1; k++) {
                    g[k][i][j] = value;
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{K, 0, 0, 1});
        v[K][0][0] = 0;

        int minValue = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int wall = temp[0];
            int x = temp[1];
            int y = temp[2];
            int count = temp[3];

            if (x == N - 1 && y == M - 1) {
                minValue = Math.min(minValue, count);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (g[wall][nx][ny] == 1){
                        if (wall > 0){
                            if (v[wall - 1][nx][ny] > count + 1) {
                                v[wall - 1][nx][ny] = count + 1;
                                q.offer(new int[]{wall - 1, nx, ny, count + 1});
                            }
                        }
                    } else {
                        if (v[wall][nx][ny] > count + 1) {
                            v[wall][nx][ny] = count + 1;
                            q.offer(new int[]{wall, nx, ny, count + 1});
                        }
                    }
                }
            }
        }

        if (minValue == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minValue);
        br.close();
    }
}