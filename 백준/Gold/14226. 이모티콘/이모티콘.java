import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        int[][] dist = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dist[i], -1);
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[1][0] = 0;
        q.offer(new int[] {1, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int screen = cur[0];
            int clipboard = cur[1];
            int time = dist[screen][clipboard];

            if (screen == S) {
                System.out.println(time);
                return;
            }

            // 1) 화면 전체 복사
            if (dist[screen][screen] == -1) {
                dist[screen][screen] = time + 1;
                q.offer(new int[] {screen, screen});
            }

            // 2) 클립보드 붙여넣기
            if (clipboard > 0 && screen + clipboard <= 1000 && dist[screen + clipboard][clipboard] == -1) {
                dist[screen + clipboard][clipboard] = time + 1;
                q.offer(new int[] {screen + clipboard, clipboard});
            }

            // 3) 화면에서 1개 삭제
            if (screen - 1 >= 0 && dist[screen - 1][clipboard] == -1) {
                dist[screen - 1][clipboard] = time + 1;
                q.offer(new int[] {screen - 1, clipboard});
            }
        }
    }
}
