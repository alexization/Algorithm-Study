import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<Integer, Integer> ladders, snakes;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ladders = addData(n);
        snakes = addData(m);

        dijkstra();

        System.out.println(answer);

        br.close();
    }

    private static HashMap<Integer, Integer> addData(int n) throws IOException {
        HashMap<Integer, Integer> tempMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tempMap.put(from, to);
        }
        return tempMap;
    }

    private static void dijkstra() {
        int[] visited = new int[101];
        Arrays.fill(visited, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int now = curr[0];
            int count = curr[1];

            if (now == 100) {
                answer = count;
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next > 100) continue;

                if (ladders.containsKey(next)) {
                    visited[ladders.get(next)] = count + 1;
                    pq.offer(new int[]{ladders.get(next), count + 1});
                    continue;
                }

                if (snakes.containsKey(next)) {
                    visited[snakes.get(next)] = count + 1;
                    pq.offer(new int[]{snakes.get(next), count + 1});
                    continue;
                }

                if (visited[next] > count + 1) {
                    visited[next] = count + 1;
                    pq.offer(new int[]{next, count + 1});
                }
            }
        }
    }
}