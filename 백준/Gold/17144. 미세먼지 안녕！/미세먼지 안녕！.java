import java.io.*;
import java.util.*;

public class Main {

    public static int R, C, T;
    public static int ac = -1;
    public static ArrayDeque<int[]> dustPos = new ArrayDeque<>();

    public static int[] dx = { 0, 0, -1, 1 };
    public static int[] dy = { -1, 1, 0, 0 };

    public static int[][][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[2][R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                int value = Integer.parseInt(st.nextToken());
                graph[0][i][j] = value;
                if (value == -1 && ac == -1) {
                    ac = i;
                    continue;
                }

                if (value != 0) {
                    dustPos.offer(new int[] { i, j });
                    continue;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            // 미세먼지 확산
            while (!dustPos.isEmpty()) {
                int[] cur = dustPos.poll();
                moveDust(cur[0], cur[1]);
            }

            // 공기청정기 작동
            turnTopArea();
            turnBottomArea();

            addDust();
        }

        int result = 0;
        for (int[] temp : graph[0]) {
            for (int value : temp) {
                if (value > 0) result += value;
            }
        }

        System.out.println(result);
    }

    static void moveDust(int x, int y) {
        int count = 0;
        int dustValue = (int) Math.floor(graph[0][x][y] / 5);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (graph[0][nx][ny] == -1) continue;

            count++;
            graph[1][nx][ny] += dustValue;
        }

        int remain = graph[0][x][y] - dustValue * count;
        if (remain > 0) {
            graph[1][x][y] += remain;
        }
    }

    static void addDust() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[0][i][j] == -1) {
                    continue;
                }

                graph[0][i][j] = graph[1][i][j];
                if (graph[1][i][j] > 0) dustPos.offer(new int[] { i, j });
                graph[1][i][j] = 0;
            }
        }
    }

    static void turnTopArea() {
        for (int i = ac - 1; i > 0; i--) graph[1][i][0] = graph[1][i - 1][0];
        for (int i = 0; i < C - 1; i++) graph[1][0][i] = graph[1][0][i + 1];
        for (int i = 0; i < ac; i++) graph[1][i][C - 1] = graph[1][i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) graph[1][ac][i] = graph[1][ac][i - 1];
        graph[1][ac][1] = 0;
    }

    static void turnBottomArea() {
        int bottom = ac + 1;

        for (int i = bottom + 1; i < R - 1; i++) graph[1][i][0] = graph[1][i + 1][0];
        for (int i = 0; i < C - 1; i++) graph[1][R - 1][i] = graph[1][R - 1][i + 1];
        for (int i = R - 1; i > bottom; i--) graph[1][i][C - 1] = graph[1][i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) graph[1][bottom][i] = graph[1][bottom][i - 1];
        graph[1][bottom][1] = 0;
    }
}
