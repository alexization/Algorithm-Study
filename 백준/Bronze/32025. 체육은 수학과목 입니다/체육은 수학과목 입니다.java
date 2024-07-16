import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();

        int length = Math.min(H, W);
        System.out.println(length * 100 / 2);
        sc.close();
    }
}
