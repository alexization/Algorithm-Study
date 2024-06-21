import java.util.*;
import java.io.*;

public class Main {

	static int N, a, b, minValue = 1_000_000_000;
	static int[][] arr;
	
	static void subs(int cnt, int A, int B, int select) {
		if (cnt == N) {
			if (select == 0) return;
			int value = Math.abs(A-B);
			minValue = minValue > value ? value : minValue;
			return;
		}
		
		subs(cnt+1, A*arr[cnt][0], B+arr[cnt][1], select+1);
		subs(cnt+1, A, B, select);
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}		
		subs(0, 1, 0, 0);
		System.out.println(minValue);
		br.close();
	}
}
