import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int idx = q.poll();
            sb.append(idx).append(" ");
            List<Integer> temp = graph.get(idx);
            for (int i = 0; i < temp.size(); i++) {
                if (--indegree[temp.get(i)] == 0) {
                    q.offer(temp.get(i));
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}