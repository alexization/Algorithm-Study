import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        System.out.println(Math.min(Math.min(w - x, h - y), Math.min(x, y)));

        sc.close();
    }
}
