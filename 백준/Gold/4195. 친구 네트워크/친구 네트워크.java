import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<String, String> parents;
    static HashMap<String, Integer> childCounts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int f = Integer.parseInt(br.readLine());

            parents = new HashMap<>();
            childCounts = new HashMap<>();

            for (int j = 0; j < f; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String a = st.nextToken();
                String b = st.nextToken();

                if (!parents.containsKey(a)) {
                    parents.put(a, a);
                    childCounts.put(a, 1);
                }
                if (!parents.containsKey(b)) {
                    parents.put(b, b);
                    childCounts.put(b, 1);
                }

                union(a, b);
                System.out.println(childCounts.get(find_parent(a)));
            }
        }

        br.close();
    }

    private static String find_parent(String name) {
        String parentName = parents.get(name);
        if (name.equals(parentName)) {
            return name;
        } else {
            parents.put(name, find_parent(parentName));
            return parents.get(name);
        }
    }

    private static void union(String a, String b) {
        String pa = find_parent(a);
        String pb = find_parent(b);

        if (pa.compareTo(pb) == 0) {
            return;
        }
        if (pa.compareTo(pb) < 0) {
            parents.put(pb, pa);
            childCounts.put(pa, childCounts.get(pa) + childCounts.get(pb));
        } else {
            parents.put(pa, pb);
            childCounts.put(pb, childCounts.get(pb) + childCounts.get(pa));
        }
    }
}