import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int result = Integer.parseInt(N);
        if (Integer.parseInt(N) >= 100) {
            result = 99;
            for (int i = 110; i <= Integer.parseInt(N); i++) {
                String str = Integer.toString(i);
                int temp = str.charAt(0) - str.charAt(1) - '0';
                boolean status = true;
                for (int j = 1; j < str.length() - 1; j++) {
                    if (temp != str.charAt(j) - str.charAt(j + 1) - '0') {
                        status = false;
                        break;
                    }
                }
                if (status) result++;
            }
        }
        System.out.println(result);
        sc.close();
    }
}
