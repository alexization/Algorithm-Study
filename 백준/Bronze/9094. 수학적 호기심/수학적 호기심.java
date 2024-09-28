import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int result = 0;
            for (int j = 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (((double) (j * j + k * k + m) / (j*k)) % 1 == 0.0) result++;
                }
            }
            System.out.println(result);
        }


        br.close();
    }
}
