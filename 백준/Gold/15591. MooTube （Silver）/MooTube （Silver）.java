import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, q;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            graph[to].add(new int[]{from, r});
            graph[from].add(new int[]{to, r});
        }


        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            System.out.println(dijkstra(k, v));
        }

        br.close();
    }

    private static int dijkstra(int score, int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[start] = Integer.MAX_VALUE;

        pq.offer(new int[]{start, Integer.MAX_VALUE});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int now = current[0];
            int dist = current[1];

            if (distance[now] > dist) continue;

            for (int[] next : graph[now]) {
                int nextNode = next[0];
                int cost = Math.min(dist, next[1]);

                if (distance[nextNode] < cost) {
                    distance[nextNode] = cost;
                    pq.offer(new int[]{nextNode, cost});
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i != start && distance[i] >= score) {
                count++;
            }
        }
        return count;
    }

}