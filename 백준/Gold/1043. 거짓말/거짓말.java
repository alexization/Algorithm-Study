import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parents;
    static ArrayList<Integer> knowMembers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        if (count == 0) {
            System.out.println(m);
            return;
        }

        for (int i = 0; i < count; i++) {
            knowMembers.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer>[] parties = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            parties[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int memberCnt = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            parties[i].add(x);

            for (int j = 1; j < memberCnt; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                parties[i].add(y);
            }
        }

        Set<Integer> knows = new HashSet<>();
        for (int knowMember : knowMembers) {
            knows.add(find_parent(knowMember));
        }

        int answer = 0;
        for (ArrayList<Integer> party : parties) {
            boolean canPlus = true;
            for (int member : party) {
                if (knows.contains(find_parent(member))) {
                    canPlus = false;
                    break;
                }
            }
            if (canPlus) answer++;
        }

        System.out.println(answer);
        br.close();
    }

    private static int find_parent(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find_parent(parents[x]);
    }

    private static void union(int x, int y) {
        int px = find_parent(x);
        int py = find_parent(y);

        if (px == py) return;
        if (px < py) {
            parents[py] = px;
        } else {
            parents[px] = py;
        }
    }
}