import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int count = 0;

        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                continue;
            }
            c = str.charAt(i);
            count++;
        }

        if (count % 2 == 0) System.out.println(count / 2);
        else System.out.println(count / 2 + 1);
    }
}