import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (cmd == 0) {
                union(a, b);
            } else {
                if (find_parent(a) == find_parent(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        br.close();
    }

    private static int find_parent(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find_parent(parents[x]);
    }

    private static void union(int a, int b) {
        int pa = find_parent(a);
        int pb = find_parent(b);

        if (pa == pb) {
            return;
        }
        if (pa > pb) {
            parents[pa] = pb;
        } else {
            parents[pb] = pa;
        }
    }
}