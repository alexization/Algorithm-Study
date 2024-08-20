import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            minValue = Math.min(minValue, Integer.parseInt(br.readLine()));
        }
        result = minValue;
        minValue = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            minValue = Math.min(minValue, Integer.parseInt(br.readLine()));
        }
        result += minValue;
        result -= 50;
        System.out.println(result);
        br.close();
    }
}
