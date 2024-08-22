import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        BigInteger num = new BigInteger("2");
        BigInteger even = new BigInteger("0");
        for (int i = 0; i < N; i++) {
            BigInteger value = new BigInteger(br.readLine());
            if (value.mod(num).equals(even)) {
                sb.append("even").append("\n");
            } else {
                sb.append("odd").append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
