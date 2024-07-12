import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        BitSet bitSet = new BitSet(33554433);

        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            if (bitSet.get(value)) continue;
            bitSet.set(value);
            sb.append(value).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}