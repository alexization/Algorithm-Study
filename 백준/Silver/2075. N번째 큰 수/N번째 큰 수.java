import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int value = Integer.parseInt(st.nextToken());
                pq.offer(value);
            }
        }

        int result = -1;
        for (int i = 0; i < n; i++){
            result = pq.poll();
        }

        System.out.println(result);
        br.close();
    }
}