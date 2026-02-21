import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int S = Integer.parseInt(br.readLine());

        int minTime = 1;
        int clipboardCount = 1;
        int totalEmojiCount = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[1001][1001];
        Arrays.fill(visited[0], true);

        pq.offer(new int[] { minTime, clipboardCount, totalEmojiCount });

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int time = temp[0];
            int clipboard = temp[1];
            int totalEmoji = temp[2];

            if (totalEmoji == S) {
                minTime = time;
                break;
            }

            if (totalEmoji > S) continue;
            if (visited[totalEmoji][clipboard]) continue;

            visited[totalEmoji][clipboard] = true;

            // 1. 모든 이모티콘을 복사해서 클립보드에 붙여넣기
            pq.offer(new int[] { time + 1, totalEmoji, totalEmoji });

            // 2. 클립보드에 있는 이모티콘 붙여넣기
            pq.offer(new int[] { time + 1, clipboard, totalEmoji + clipboard });

            // 3. 이모티콘 한개 제거
            pq.offer(new int[] { time + 1, clipboard, totalEmoji - 1 });
        }

        System.out.println(minTime);
    }
}
