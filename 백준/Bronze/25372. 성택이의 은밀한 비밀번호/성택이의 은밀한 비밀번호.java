import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            if (str.length() >= 6 && str.length() <= 9) System.out.println("yes");
            else System.out.println("no");
        }

        sc.close();
    }
}
