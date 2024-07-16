import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][][] g = new int[K + 1][N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                for (int k = 0; k < K + 1; k++) {
                    g[k][i][j] = value;
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int[] sx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] sy = {-1, 1, -2, 2, -2, 2, -1, 1};

        boolean[][][] v = new boolean[K + 1][N][M];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, K, 0});
        v[0][0][0] = true;

        int nx = 0, ny = 0;
        int result = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int skill = temp[2];
            int count = temp[3];

            if (x == N - 1 && y == M - 1) {
                result = Math.min(result, count);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (g[skill][nx][ny] == 1) continue;
                    if (v[skill][nx][ny]) continue;
                    v[skill][nx][ny] = true;
                    q.offer(new int[]{nx, ny, skill, count + 1});
                }
            }

            if (skill > 0){
                for (int i = 0; i < 8; i++) {
                    nx = x + sx[i];
                    ny = y + sy[i];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (g[skill][nx][ny] == 1) continue;
                        if (v[skill - 1][nx][ny]) continue;
                        v[skill-1][nx][ny] = true;
                        q.offer(new int[]{nx, ny, skill-1, count + 1});
                    }
                }
            }
        }

        if (result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);

        br.close();
    }

}
