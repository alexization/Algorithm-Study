import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        if (N*100 >= M) System.out.println("Yes");
        else System.out.println("No");

        sc.close();
    }
}
