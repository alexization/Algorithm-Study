import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char value = str.charAt(i);
            if (Character.isLowerCase(value)) sb.append(Character.toUpperCase(value));
            else sb.append(Character.toLowerCase(value));
        }
        System.out.println(sb);
        sc.close();
    }
}