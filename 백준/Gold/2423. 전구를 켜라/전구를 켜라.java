import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        /* / = 0, \ = 1 */
        int[][] move = new int[n][m];
        for (int[] mo : move) Arrays.fill(mo, -1);

        Deque<int[]> dq = new LinkedList<>();
        if (graph[0][0] == '/') {
            move[0][0] = 1;
            dq.offer(new int[]{0, 0, 1});
        } else {
            move[0][0] = 0;
            dq.offer(new int[]{0, 0, 1});
        }

        while (!dq.isEmpty()) {
            int[] temp = dq.poll();
            int x = temp[0];
            int y = temp[1];
            int dist = temp[2];

            if (x == n - 1 && y == m - 1 && dist == 0) {
                move[x][y] = -1;
                continue;
            }

            /* \ 인 경우 갈 수 있는 곳
             * 1. 우측 아래가 \ 인 경우
             * 2. 우측이 / 인 경우
             * 3. 위측이 / 인 경우
             * 4. 아래측이 / 인 경우
             * 5. 좌측이 / 인 경우
             * 6. 좌측 위가 \ 인 경우 */
            if (dist == 1) {
                /* 우측 아래 확인 */
                if (isAvailable(x + 1, y + 1)) {
                    /* 우측 아래가 \ 인 경우, 회전 X */
                    if (graph[x + 1][y + 1] == '\\' && move[x + 1][y + 1] == -1) {
                        move[x + 1][y + 1] = move[x][y];
                        dq.addFirst(new int[]{x + 1, y + 1, 1});
                        /* 우측 아래가 / 인 경우, 회전 O */
                    } else if (graph[x + 1][y + 1] == '/' && move[x + 1][y + 1] == -1) {
                        move[x + 1][y + 1] = move[x][y] + 1;
                        dq.offer(new int[]{x + 1, y + 1, 1});
                    }
                }
                /* 우측 확인 */
                if (isAvailable(x, y + 1)) {
                    /* 우측이 / 인 경우, 회전 X */
                    if (graph[x][y + 1] == '/' && move[x][y + 1] == -1) {
                        move[x][y + 1] = move[x][y];
                        dq.addFirst(new int[]{x, y + 1, 0});
                    }
                    /* 우측이 \ 인 경우, 회전 O */
                    if (graph[x][y + 1] == '\\' && move[x][y + 1] == -1) {
                        move[x][y + 1] = move[x][y] + 1;
                        dq.offer(new int[]{x, y + 1, 0});
                    }
                }
                /* 위측 확인 */
                if (isAvailable(x - 1, y)) {
                    /* 위측이 \ 인 경우, 회전 O */
                    if (graph[x - 1][y] == '\\' && move[x - 1][y] == -1) {
                        move[x - 1][y] = move[x][y] + 1;
                        dq.offer(new int[]{x - 1, y, 0});
                    }
                    /* 위측이 / 인 경우, 회전 X */
                    if (graph[x - 1][y] == '/' && move[x - 1][y] == -1) {
                        move[x - 1][y] = move[x][y];
                        dq.addFirst(new int[]{x - 1, y, 0});
                    }
                }
                /* 아래측 확인 */
                if (isAvailable(x + 1, y)) {
                    /* 아래측이 / 인 경우, 회전 X */
                    if (graph[x + 1][y] == '/' && move[x + 1][y] == -1) {
                        move[x + 1][y] = move[x][y];
                        dq.addFirst(new int[]{x + 1, y, 0});
                    }
                    /* 아래측이 \ 인 경우, 회전 O */
                    if (graph[x + 1][y] == '\\' && move[x + 1][y] == -1) {
                        move[x + 1][y] = move[x][y] + 1;
                        dq.offer(new int[]{x + 1, y, 0});
                    }
                }
                /* 좌측 확인 */
                if (isAvailable(x, y - 1)) {
                    /* 좌측이 / 인 경우, 회전 X */
                    if (graph[x][y - 1] == '/' && move[x][y - 1] == -1) {
                        move[x][y - 1] = move[x][y];
                        dq.addFirst(new int[]{x, y - 1, 0});
                    }
                    /* 좌측이 \ 인 경우, 회전 O */
                    if (graph[x][y - 1] == '\\' && move[x][y - 1] == -1) {
                        move[x][y - 1] = move[x][y] + 1;
                        dq.offer(new int[]{x, y - 1, 0});
                    }
                }
                /* 좌측 위 확인 */
                if (isAvailable(x - 1, y - 1)) {
                    /* 좌측 위가 \ 인 경우, 회전 X */
                    if (graph[x - 1][y - 1] == '\\' && move[x - 1][y - 1] == -1) {
                        move[x - 1][y - 1] = move[x][y];
                        dq.addFirst(new int[]{x - 1, y - 1, 1});
                    }
                    /* 좌측 위가 / 인 경우, 회전 O */
                    if (graph[x - 1][y - 1] == '/' && move[x - 1][y - 1] == -1) {
                        move[x - 1][y - 1] = move[x][y] + 1;
                        dq.offer(new int[]{x - 1, y - 1, 1});
                    }
                }

                /* / 인 경우 갈 수 있는 곳
                 * 1. 우측이 \ 인 경우
                 * 2. 우측 위가 / 인 경우
                 * 3. 위측이 \ 인 경우
                 * 4. 아래측이 \ 인 경우
                 * 5. 좌측이 \ 인 경우
                 * 6. 좌측 아래가 / 인 경우 */
            } else {
                /* 우측 확인 */
                if (isAvailable(x, y + 1)) {
                    /* 우측이 / 인 경우, 회전 O */
                    if (graph[x][y + 1] == '/' && move[x][y + 1] == -1) {
                        move[x][y + 1] = move[x][y] + 1;
                        dq.offer(new int[]{x, y + 1, 1});
                    }
                    /* 우측이 \ 인 경우, 회전 X */
                    if (graph[x][y + 1] == '\\' && move[x][y + 1] == -1) {
                        move[x][y + 1] = move[x][y];
                        dq.addFirst(new int[]{x, y + 1, 1});
                    }
                }
                /* 우측 위 확인 */
                if (isAvailable(x - 1, y + 1)) {
                    /* 우측 위가 \ 인 경우, 회전 O */
                    if (graph[x - 1][y + 1] == '\\' && move[x - 1][y + 1] == -1) {
                        move[x - 1][y + 1] = move[x][y] + 1;
                        dq.offer(new int[]{x - 1, y + 1, 0});
                        /* 우측 위가 / 인 경우, 회전 X */
                    } else if (graph[x - 1][y + 1] == '/' && move[x - 1][y + 1] == -1) {
                        move[x - 1][y + 1] = move[x][y];
                        dq.addFirst(new int[]{x - 1, y + 1, 0});
                    }
                }
                /* 위측 확인 */
                if (isAvailable(x - 1, y)) {
                    /* 위측이 \ 인 경우, 회전 X */
                    if (graph[x - 1][y] == '\\' && move[x - 1][y] == -1) {
                        move[x - 1][y] = move[x][y];
                        dq.addFirst(new int[]{x - 1, y, 1});
                    }
                    /* 위측이 / 인 경우, 회전 O */
                    if (graph[x - 1][y] == '/' && move[x - 1][y] == -1) {
                        move[x - 1][y] = move[x][y] + 1;
                        dq.offer(new int[]{x - 1, y, 1});
                    }
                }
                /* 아래측 확인 */
                if (isAvailable(x + 1, y)) {
                    /* 아래측이 / 인 경우, 회전 O */
                    if (graph[x + 1][y] == '/' && move[x + 1][y] == -1) {
                        move[x + 1][y] = move[x][y] + 1;
                        dq.offer(new int[]{x + 1, y, 1});
                    }
                    /* 아래측이 \ 인 경우, 회전 X */
                    if (graph[x + 1][y] == '\\' && move[x + 1][y] == -1) {
                        move[x + 1][y] = move[x][y];
                        dq.addFirst(new int[]{x + 1, y, 1});
                    }
                }
                /* 좌측 아래 확인 */
                if (isAvailable(x + 1, y - 1)) {
                    /* 좌측 아래가 / 인 경우, 회전 X */
                    if (graph[x + 1][y - 1] == '/' && move[x + 1][y - 1] == -1) {
                        move[x + 1][y - 1] = move[x][y];
                        dq.addFirst(new int[]{x + 1, y - 1, 0});
                    }
                    /* 좌측이 \ 인 경우, 회전 O */
                    if (graph[x + 1][y - 1] == '\\' && move[x + 1][y - 1] == -1) {
                        move[x + 1][y - 1] = move[x][y] + 1;
                        dq.offer(new int[]{x + 1, y - 1, 0});
                    }
                }
                /* 좌측 확인 */
                if (isAvailable(x, y - 1)) {
                    /* 좌측이 / 인 경우, 회전 O */
                    if (graph[x][y - 1] == '/' && move[x][y - 1] == -1) {
                        move[x][y - 1] = move[x][y] + 1;
                        dq.offer(new int[]{x, y - 1, 1});
                    }
                    /* 좌측이 \ 인 경우, 회전 X */
                    if (graph[x][y - 1] == '\\' && move[x][y - 1] == -1) {
                        move[x][y - 1] = move[x][y];
                        dq.addFirst(new int[]{x, y - 1, 1});
                    }
                }
            }
        }

        if (move[n - 1][m - 1] == -1) System.out.println("NO SOLUTION");
        else System.out.println(move[n - 1][m - 1]);

        br.close();
    }

    private static boolean isAvailable(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}