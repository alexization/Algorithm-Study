import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] money = new int[N];
		for (int i=0;i<N;i++) money[i] = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = N-1; i >= 0;i--) {
			if (K >= money[i]) {
				count += K / money[i];
				K %= money[i];
			}
		}
		
		System.out.println(count);
		br.close();
	}
}