import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> -(o2 - o1));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int midValue = Integer.parseInt(br.readLine());
        sb.append(midValue).append("\n");
        for (int i = 0; i < N - 1; i++) {
            int value = Integer.parseInt(br.readLine());
            if (midValue <= value) minHeap.offer(value);
            else maxHeap.offer(value);

            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(midValue);
                midValue = minHeap.poll();
            } else if (maxHeap.size() - minHeap.size() >= 1) {
                minHeap.offer(midValue);
                midValue = maxHeap.poll();
            }
            sb.append(midValue).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}