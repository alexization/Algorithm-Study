import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String pattern = br.readLine();

        int count = 0;
        for (int i = 0; i <= str.length() - pattern.length(); i++) {
            boolean status = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (str.charAt(i + j) != pattern.charAt(j)) {
                    status = false;
                    break;
                }
            }
            if (status) {
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}
