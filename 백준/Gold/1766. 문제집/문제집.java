import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            g.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g.get(a).add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int idx = q.poll();
            sb.append(idx).append(" ");
            for (Integer next : g.get(idx)) {
                if (--indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}