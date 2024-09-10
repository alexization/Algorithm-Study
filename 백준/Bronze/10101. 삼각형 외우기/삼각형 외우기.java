import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            set.add(value);
        }
        if (sum != 180) System.out.println("Error");
        else if (set.size() == 1) {
            System.out.println("Equilateral");
        } else if (set.size() == 2) {
            System.out.println("Isosceles");
        } else if (set.size() == 3) {
            System.out.println("Scalene");
        }
        br.close();
    }
}