import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numArr = new int[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> calList = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        int count = 0;
        for (int num : numArr) {
            if (prev < num) {
                count++;
            } else {
                calList.add(count);
                count = 1;
            }
            prev = num;
        }

        calList.add(count);

        long answer = n;
        for (int cal : calList) {
            answer += ((long) cal * (cal - 1)) / 2;
        }

        System.out.println(answer);
        br.close();
    }

}