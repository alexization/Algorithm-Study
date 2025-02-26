import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNumber = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            parents = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                parents[i] = i;
            }

            Set<Integer> resultSet = new HashSet<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            for (int i = 1; i < parents.length; i++) {
                int pa = find_parent(i);
                if (pa > 0) {
                    resultSet.add(pa);
                }
            }

            System.out.print("Case " + caseNumber + ": ");

            if (resultSet.isEmpty()) {
                System.out.println("No trees.");
            } else if (resultSet.size() == 1) {
                System.out.println("There is one tree.");
            } else {
                System.out.println("A forest of " + resultSet.size() + " trees.");
            }
            caseNumber++;
        }
        br.close();
    }

    private static int find_parent(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find_parent(parents[a]);
    }

    private static void union(int a, int b) {
        int pa = find_parent(a);
        int pb = find_parent(b);

        if (pa == pb) {
            parents[pa] = 0;
        } else if (pb > pa) {
            parents[pb] = pa;
        } else {
            parents[pa] = pb;
        }
    }
}