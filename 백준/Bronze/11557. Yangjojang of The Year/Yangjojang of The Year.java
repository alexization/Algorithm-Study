import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            String maxName = "";
            int maxValue = -1;
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                if (maxValue < value) {
                    maxValue = value;
                    maxName = name;
                }
            }
            System.out.println(maxName);
        }
        br.close();
    }
}
