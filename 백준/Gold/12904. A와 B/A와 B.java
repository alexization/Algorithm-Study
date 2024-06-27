import java.util.*;
import java.io.*;

public class Main {

	static String S, T;
	static boolean status;
	static StringBuilder sb;
	
	static void check() {
		while (sb.toString().length() != S.length()) {
			if (sb.charAt(sb.length()-1) == 'A') sb.deleteCharAt(sb.length()-1);
			else {
				sb.deleteCharAt(sb.length()-1);
				sb.reverse();
			}
			if (sb.toString().equals(S)) {
				status = true;
				break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		sb = new StringBuilder();
		sb.append(T);
		check();
		if (status) System.out.println(1);
		else System.out.println(0);
        br.close();
	}
}
