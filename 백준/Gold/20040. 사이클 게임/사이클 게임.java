import java.util.*;
import java.io.*;

public class Main {

    static int[] p;
    static boolean cycle = false;

    static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b) {
            cycle = true;
            return false;
        }
        if (a < b) p[a] = b;
        else p[b] = a;
        return true;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> g = new ArrayList<>();
        p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
        for (int i = 0; i < N; i++) {
            g.add(new ArrayList<>());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            count++;
            if (!union(a, b)) break;
        }

        if (count == M && !cycle) System.out.println(0);
        else System.out.println(count);

        br.close();
    }
}
