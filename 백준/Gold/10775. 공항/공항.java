import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static boolean union_find(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }

        if (rootA > rootB) {
            parent[a] = rootB;
        } else {
            parent[b] = rootA;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G + 1];
        for (int i = 1; i < G + 1; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 0; i < P; i++) {
            int value = Integer.parseInt(br.readLine());
            if (find(value) == value) {
                union_find(value, value - 1);
            } else {
                if (find(value) == 0) break;
                union_find(find(value), find(value) - 1);
            }
            result++;
        }
        System.out.println(result);
        br.close();
    }
}
