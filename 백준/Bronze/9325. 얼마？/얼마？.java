import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int s = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int q = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                s += (q * p);
            }
            System.out.println(s);
        }
        br.close();
    }
}