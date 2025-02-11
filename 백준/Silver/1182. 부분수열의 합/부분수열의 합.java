import java.io.*;
import java.util.*;

public class Main {

    static int n, s;
    static int count = 0;
    static int[] numArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        numArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0, 0);
        System.out.println(count);
        br.close();
    }


    private static void permutation(int value, int index) {
        for (int i = index; i < n; i++) {
            if (value + numArr[i] == s) count++;
            permutation(value + numArr[i], i + 1);
        }
    }
}