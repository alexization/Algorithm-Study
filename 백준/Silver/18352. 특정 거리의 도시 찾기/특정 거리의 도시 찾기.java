import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시
        
        // 그래프 초기화
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 도로 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }
        
        // 우선순위 큐를 활용한 BFS
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); // 거리 오름차순
        pq.add(new int[]{X, 0}); // 출발 도시, 거리
        
        boolean[] visited = new boolean[N + 1];
        visited[X] = true;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int city = current[0];
            int distance = current[1];
            
            if (distance == K) {
                result.add(city); // 거리 K인 도시 추가
            }
            
            if (distance > K) {
                break; // 더 이상 탐색할 필요 없음
            }
            
            for (int next : graph[city]) {
                if (!visited[next]) {
                    visited[next] = true;
                    pq.add(new int[]{next, distance + 1});
                }
            }
        }
        
        // 결과 출력
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result); // 오름차순 정렬
            for (int city : result) {
                System.out.println(city);
            }
        }
    }
}