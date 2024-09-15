import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true) {
            int value = Integer.parseInt(br.readLine());
            if (value == -1) break;
            sum += value;
        }
        System.out.println(sum);
        br.close();
    }
}