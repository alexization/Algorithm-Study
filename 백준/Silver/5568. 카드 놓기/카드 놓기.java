import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int k;
    static String[] cardArr;
    static Set<String> combResult = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        cardArr = new String[n];
        for (int i = 0; i < n; i++) {
            cardArr[i] = br.readLine();
        }

        boolean[] visited = new boolean[n];
        combination(0, "", visited);

        System.out.println(combResult.size());
    }

    private static void combination(int depth, String str, boolean[] visited) {
        if (depth == k) {
            combResult.add(str);
            return;
        }

        for (int i = 0; i < cardArr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            combination(depth + 1, str + cardArr[i], visited);
            visited[i] = false;
        }
    }
}