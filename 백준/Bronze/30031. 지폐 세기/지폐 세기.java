import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)  throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        map.put(136, 1000);
        map.put(142, 5000);
        map.put(148, 10000);
        map.put(154, 50000);

        int result = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int value = Integer.parseInt(str.split(" ")[0]);
            result += map.get(value);
        }
        System.out.println(result);
        br.close();
    }
}
