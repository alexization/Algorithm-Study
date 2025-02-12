import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] numArr;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numArr = new int[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);
        permutaion(0, 0, new int[m]);

        System.out.println(result);

        br.close();
    }

    private static void permutaion(int index, int depth, int[] value) {
        if (depth == m) {
            for (int val : value) {
                result.append(val).append(" ");
            }
            result.append("\n");
            return;
        }

        int prev = -1;
        for (int i = index; i < n; i++) {
            if (prev != numArr[i]) {
                prev = numArr[i];
                value[depth] = prev;
                permutaion(i + 1, depth + 1, value);
            }
        }
    }
}