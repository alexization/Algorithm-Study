import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] buckets = new int[3];
        buckets[0] = Integer.parseInt(st.nextToken());
        buckets[1] = Integer.parseInt(st.nextToken());
        buckets[2] = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[201][201];
        boolean[] result = new boolean[201];
        deque.offer(new int[] { 0, 0, buckets[2] });

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            if (visited[cur[0]][cur[1]]) continue;

            if (cur[0] == 0) result[cur[2]] = true;
            visited[cur[0]][cur[1]] = true;

            for (int i = 0; i < 3; i++) {
                int from = cur[i];

                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    int to = cur[j];

                    int remainIdx = 3 - i - j;

                    int[] next = new int[3];
                    next[i] =
                        (from - (buckets[j] - to)) < 0
                            ? 0
                            : from - (buckets[j] - to);
                    next[j] = (to + from) > buckets[j] ? buckets[j] : to + from;
                    next[remainIdx] = cur[remainIdx];

                    deque.offer(new int[] { next[0], next[1], next[2] });
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 201; i++) {
            if (!result[i]) continue;
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
