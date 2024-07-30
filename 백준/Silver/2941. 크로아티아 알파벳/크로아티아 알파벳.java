import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] alp = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0; i < alp.length; i++) {
            str = str.replace(alp[i], "1");
        }

        System.out.println(str.length());
        sc.close();
    }
}
