import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char firstChar = str.charAt(0);
        int count = 0;
        for (Character c : str.toCharArray()) {
            if (c == firstChar) count++;
            else break;
        }

        System.out.println(count);
        sc.close();
    }
}
