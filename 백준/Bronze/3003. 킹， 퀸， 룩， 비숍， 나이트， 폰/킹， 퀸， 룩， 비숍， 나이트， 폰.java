import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int[] corArr = {1, 1, 2, 2, 2, 8};
        int[] inputArr = new int[6];
        for (int i = 0; i < 6; i++) {
            inputArr[i] = sc.nextInt();
        }

        for (int i = 0; i < 6; i++) {
            System.out.print(corArr[i] - inputArr[i] + " ");
        }
        sc.close();
    }
}