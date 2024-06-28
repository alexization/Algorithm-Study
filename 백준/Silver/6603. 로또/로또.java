import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] a, b;
	static StringBuilder sb;
	
	static void comb(int idx, int start) {
		if (idx == 6) {
			for (int temp : b) sb.append(temp).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			b[idx] = a[i];
			comb(idx+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sb = new StringBuilder();
			
			N = Integer.parseInt(st.nextToken());
			if (N == 0) break;
			a = new int[N];
			b = new int[6];
			for (int i=0;i<N;i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0);
			System.out.println(sb);
		}
		br.close();
	}
}