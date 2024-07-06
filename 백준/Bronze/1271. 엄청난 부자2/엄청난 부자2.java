import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BigInteger N = sc.nextBigInteger();
        BigInteger M = sc.nextBigInteger();

        System.out.println(N.divide(M));
        System.out.println(N.remainder(M));
        sc.close();
    }
}