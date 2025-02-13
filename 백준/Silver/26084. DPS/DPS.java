import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String teamName = br.readLine();

        int n = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            countMap.put(teamName.charAt(i), countMap.getOrDefault(teamName.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> memberFirst = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            memberFirst.put(name.charAt(0), memberFirst.getOrDefault(name.charAt(0), 0) + 1);
        }

        long[] answerArr = new long[countMap.size()];
        int index = 0;
        for (char countMapKey : countMap.keySet()) {
            int countMapValue = countMap.get(countMapKey);
            
            if (!memberFirst.containsKey(countMapKey)) {
                answerArr[0] = 0;
                break;
            }
            
            int memberFirstValue = memberFirst.get(countMapKey);

            long numerator = 1L;
            long denominator = 1L;
            for (int i = 0; i < countMapValue; i++) {
                numerator *= (memberFirstValue - i);
                denominator *= (i + 1);
            }
            answerArr[index++] = (numerator / denominator);
        }

        long answer = answerArr[0];
        for (int i = 1; i < answerArr.length; i++) {
            answer *= answerArr[i];
        }
        System.out.println(answer);
        br.close();
    }

}