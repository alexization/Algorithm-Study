import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        if (L % 5 == 0) {
            System.out.println(L / 5);
        } else System.out.println((L / 5) + 1);

        br.close();
    }
}