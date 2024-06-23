import java.util.*;
import java.io.*;

public class Main {

    static int k;
    static int[] arr;
    static boolean[] v;
    static String[] cmds;
    static StringBuilder sb = new StringBuilder();

    static boolean check() {
        for (int i = 0; i < k; i++) {
            if (cmds[i].equals("<")) {
                if (arr[i] > arr[i+1]) return false;
            } else {
                if (arr[i] < arr[i+1]) return false;
            }
        }
        return true;
    }

    static void perm(int cnt) {
        if (cnt == k + 1) {
            if (check()) {
                for (int a : arr) sb.append(a);
                sb.append("\n");
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (v[i]) continue;
            v[i] = true;
            arr[cnt] = i;
            perm(cnt + 1);
            v[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        cmds = new String[k];
        v = new boolean[10];
        arr = new int[k + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            cmds[i] = st.nextToken();
        }

        perm(0);

        System.out.println(sb.substring(sb.length()-(k+2), sb.length()-1));
        System.out.println(sb.substring(0, k+1));
        br.close();
    }
}
