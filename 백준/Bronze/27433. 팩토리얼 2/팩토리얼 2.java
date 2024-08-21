import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Long result = 1L;
        for (int i = 1; i < N + 1; i++) {
            result *= i;
        }

        System.out.println(result);
        sc.close();
    }
}
