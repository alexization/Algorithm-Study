import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] numArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i=0;i<N;i++) numArr[i] = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> arrow = new HashMap<>();
		
		int result = 0;
		for (int num : numArr) {
			if (!arrow.containsKey(num)) {
				result++;
				if (arrow.containsKey(num-1)) arrow.put(num-1, arrow.get(num-1)+1);
				else arrow.put(num-1, 1);
				continue;
			}
			
			if (arrow.get(num) > 0) {
				arrow.put(num, arrow.get(num)-1);
				if (arrow.containsKey(num-1)) arrow.put(num-1, arrow.get(num-1)+1);
				else arrow.put(num-1, 1);
			} else {
				result++;
				arrow.put(num-1, arrow.get(num-1)+1);
			}
		}
		System.out.println(result);
		br.close();
	}
}