import java.util.*;
import java.io.*;

public class Main {

	static int count=0;
	static String T, P;
	static int[] table;
	static StringBuilder sb = new StringBuilder();
	
	static void patternTable() {
		for (int i=1, idx=0;i<P.length();i++) {
			while (idx > 0 && P.charAt(idx) != P.charAt(i)) {
				idx = table[idx-1];
			}
			if (P.charAt(idx) == P.charAt(i)) {
				idx++;
				table[i] = idx;
			}
		}
	}
	
	static void patternMatch() {
		for (int i=0,idx=0;i<T.length();i++) {
			while (idx > 0 && T.charAt(i) != P.charAt(idx)) {
				idx = table[idx-1];
			}
			if (T.charAt(i) == P.charAt(idx)) {
				if (idx == P.length()-1) {
					count++;
					sb.append(i-idx+1).append("\n");
					idx = table[idx];
				} else {
					idx++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = br.readLine();
		P = br.readLine();
		
		table = new int[P.length()];
		patternTable();
		patternMatch();
		
		System.out.println(count);
		System.out.println(sb);
		
		br.close();
	}
}
