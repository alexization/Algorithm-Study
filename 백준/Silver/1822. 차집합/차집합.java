import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < A; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < B; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        setA.removeAll(setB);
        Integer[] result = setA.toArray(new Integer[0]);
        Arrays.sort(result);
        System.out.println(setA.size());
        for (Integer r : result) System.out.print(r + " ");
        br.close();
    }
}
