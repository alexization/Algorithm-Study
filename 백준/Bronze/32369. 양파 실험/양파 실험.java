import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cOnion = 1;
        int bOnion = 1;
        for (int i = 0; i < N; i++) {
            cOnion += A;
            bOnion += B;
            if (cOnion < bOnion) {
                int temp = cOnion;
                cOnion = bOnion;
                bOnion = temp;
            }
            else if (cOnion == bOnion) {
                bOnion -= 1;
            }
        }

        System.out.println(cOnion + " " + bOnion);
        br.close();
    }
}