import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            int value = Integer.parseInt(br.readLine());
            count += value;
            if (Math.abs(count - 100) < minValue) {
                minValue = Math.abs(count - 100);
            } else if (Math.abs(count - 100) == minValue) {
                break;
            } else {
                count -= value;
                break;
            }
        }

        System.out.println(count);
        br.close();
    }
}
