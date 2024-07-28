import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result += sc.nextInt();
        }

        System.out.println(result);
        sc.close();
    }
}
