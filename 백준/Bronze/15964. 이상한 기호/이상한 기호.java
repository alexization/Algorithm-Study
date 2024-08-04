import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        System.out.println((A+B)*(A-B));

        sc.close();
    }
}
