import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();

        int first = X.charAt(0) - '0';
        int prev = X.charAt(1) - '0';
        int num = prev - first;
        boolean result = true;

        if (num <= 0) {
            result = false;
        }

        if ((X.charAt(X.length() - 2) - '0') - (X.charAt(X.length() - 1) - '0') <= 0) {
            result = false;
        }

        if (result) {
            for (int i = 2; i < X.length(); i++) {
                int value = X.charAt(i) - '0';
                if (value - prev == 0) {
                    result = false;
                    break;
                }

                if (num != (value - prev)) {
                    if ((value - prev) < 0) {
                        if (num > 0) {
                            num = value - prev;
                        } else {
                            result = false;
                            break;
                        }
                    } else {
                        if (num < 0) {
                            num = value - prev;
                        } else {
                            result = false;
                            break;
                        }
                    }
                }
                prev = value;
            }
        }
        if (result) {
            System.out.println("ALPSOO");
        } else {
            System.out.println("NON ALPSOO");
        }
        br.close();
    }
}