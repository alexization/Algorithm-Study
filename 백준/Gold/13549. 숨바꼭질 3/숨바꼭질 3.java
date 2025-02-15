import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();
        int[] time = new int[100001];
        Arrays.fill(time, -1);

        dq.offer(n);
        time[n] = 0;

        while (!dq.isEmpty()) {
            int pos = dq.poll();

            if (pos == k) {
                break;
            }

            if (pos * 2 <= 100000 && time[pos * 2] == -1) {
                time[pos * 2] = time[pos];
                dq.addFirst(pos * 2);
            }
            if (pos - 1 >= 0 && time[pos - 1] == -1) {
                time[pos - 1] = time[pos] + 1;
                dq.offer(pos - 1);
            }
            if (pos + 1 <= 100000 && time[pos + 1] == -1) {
                time[pos + 1] = time[pos] + 1;
                dq.offer(pos + 1);
            }
        }
        System.out.println(time[k]);
        br.close();
    }

}