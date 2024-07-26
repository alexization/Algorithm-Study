import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            String str = br.readLine();
            if (str.equals("*")) break;
            st = new StringTokenizer(str, " ");
            char match = st.nextToken().toUpperCase().charAt(0);
            boolean status = true;
            while (st.hasMoreTokens()) {
                if (match != st.nextToken().toUpperCase().charAt(0)) {
                    status = false;
                    break;
                }
            }
            if (status) System.out.println("Y");
            else System.out.println("N");
        }

        br.close();
    }
}
