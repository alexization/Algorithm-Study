import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);

        if (c == 'N' || c == 'n') {
            System.out.println("Naver D2");
        } else {
            System.out.println("Naver Whale");
        }

        sc.close();
    }
}
