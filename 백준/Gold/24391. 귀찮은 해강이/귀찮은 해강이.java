import java.io.*;
import java.util.*;

public class Main {

    static int[] p;

    static int find(int a) {
        if (p[a] == a) return a;
        return p[a] = find(p[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        p[aRoot] = bRoot;
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            p[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int result = 0;
        int first = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (first != find(next)) {
                result++;
                first = find(next);
            }
        }
        System.out.println(result);
        br.close();
    }
}
