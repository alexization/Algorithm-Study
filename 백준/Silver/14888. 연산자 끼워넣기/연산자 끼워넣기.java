import java.util.*;
import java.io.*;

public class Main {
	
	static int[] numArr;
	static int N, plus, minus, mul, div;
	static long value, maxValue = -10_000_000_000L, minValue = 10_000_000_000L;
	
	static void dfs(int depth) {
		if (depth == N-1) {
			if (maxValue < value) maxValue = value;
			if (minValue > value) minValue = value;
			return;
		}
		
		long T = value;
		if (plus > 0) {
			value += numArr[depth+1];
			plus -= 1;
			dfs(depth+1);
			value = T;
			plus += 1;
			}
		if (minus > 0) {
			value -= numArr[depth+1];
			minus -= 1;
			dfs(depth+1);
			value = T;
			minus += 1;
		}
		if (mul > 0) {
			value *= numArr[depth+1];
			mul -= 1;
			dfs(depth+1);
			value = T;
			mul += 1;
		}
		if (div > 0) {
			value /= numArr[depth+1];
			div -= 1;
			dfs(depth+1);
			value = T;
			div += 1;
		}
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		numArr = new int[N];
		for (int i=0;i<N;i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		plus = Integer.parseInt(st.nextToken());
		minus = Integer.parseInt(st.nextToken());
		mul = Integer.parseInt(st.nextToken());
		div = Integer.parseInt(st.nextToken());
		
		value = numArr[0];
		dfs(0);
		System.out.println(maxValue);
		System.out.println(minValue);
	}
}
