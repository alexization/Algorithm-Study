import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, String> answer = new HashMap<>();

        answer.put('M', "MatKor");
        answer.put('W', "WiCys");
        answer.put('C', "CyKor");
        answer.put('A', "AlKor");
        answer.put('$', "$clear");

        char value = sc.next().charAt(0);
        System.out.println(answer.get(value));

        sc.close();
    }
}
