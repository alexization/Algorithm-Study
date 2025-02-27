import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<int[]>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];
            for (int j = 0; j < n + 1; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph[b].add(new int[]{a, s});
            }

            dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(c);

            int count = 0;
            int maxValue = Integer.MIN_VALUE;
            for (int j = 1; j < n + 1; j++) {
                if (dist[j] != Integer.MAX_VALUE) {
                    maxValue = Math.max(maxValue, dist[j]);
                    count++;
                }
            }
            System.out.println(count + " " + maxValue);
        }
        br.close();
    }

    private static void dijkstra(int start) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int now = temp[0];
            int cost = temp[1];

            for (int[] next : graph[now]) {
                if (dist[next[0]] > cost + next[1]) {
                    dist[next[0]] = cost + next[1];
                    pq.offer(new int[]{next[0], cost + next[1]});
                }
            }
        }
    }
}