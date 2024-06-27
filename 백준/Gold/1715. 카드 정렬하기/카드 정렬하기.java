import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) q.add(Integer.parseInt(br.readLine()));

        int result = 0;
        for (int i = 0; i < N-1; i++) {
            int left = q.poll();
            int right = q.poll();
            result += (left + right);
            q.add(left + right);
        }

        System.out.println(result);

        br.close();
    }
}