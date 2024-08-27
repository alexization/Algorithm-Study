import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int pass = 0;
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'O') pass++;
            }
            if ((M - pass) < pass) result++;
        }
        System.out.println(result);
        br.close();
    }
}
