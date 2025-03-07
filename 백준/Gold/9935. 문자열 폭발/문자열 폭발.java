import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bombStr = br.readLine();
        int strLength = str.length();
        int bombLength = bombStr.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < strLength; i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= bombLength) {
                boolean isBomb = true;
                for (int j = 0; j < bombLength; j++) {
                    if (stack.get(stack.size() - bombLength + j) != bombStr.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    for (int j = 0; j < bombLength; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
        br.close();
    }
}