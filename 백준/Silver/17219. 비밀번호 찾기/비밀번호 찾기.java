import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> passwords = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String url = st.nextToken();
            String pwd = st.nextToken();
            passwords.put(url, pwd);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String url = br.readLine();
            sb.append(passwords.get(url)).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}