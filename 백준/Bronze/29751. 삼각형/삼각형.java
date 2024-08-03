import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        double A = W * H * 0.5;
        System.out.printf("%.1f", A);
        sc.close();
    }
}
