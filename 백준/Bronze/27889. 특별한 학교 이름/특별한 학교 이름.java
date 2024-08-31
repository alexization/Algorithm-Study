import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Map<String, String> schools = new HashMap<>();
        schools.put("NLCS", "North London Collegiate School");
        schools.put("BHA", "Branksome Hall Asia");
        schools.put("KIS", "Korea International School");
        schools.put("SJA", "St. Johnsbury Academy");

        System.out.println(schools.get(str));
        br.close();
    }
}
