import java.util.*;
import java.io.*;

public class Main {
	static ArrayDeque<Character> dq1 = new ArrayDeque<>();
	static ArrayDeque<Character> dq2 = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		char[] word = br.readLine().toCharArray();
		
		for(int i = 0; i < word.length; i++) dq1.addLast(word[i]);
		
		int M = Integer.parseInt(br.readLine());
		String cmd = "";
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			cmd = st.nextToken();
			
			if (cmd.equals("P")) {
				String value = st.nextToken();
				dq1.addLast(value.charAt(0));
				continue;
			}
			
			if (!dq1.isEmpty()) {
				if (cmd.equals("L")) dq2.addFirst(dq1.pollLast());
				else if (cmd.equals("B")) dq1.pollLast();
			} 
			if (!dq2.isEmpty()) {
				if (cmd.equals("D")) dq1.addLast(dq2.pollFirst());
			}
		}

		for(Character c : dq1) sb.append(c);
		for(Character c : dq2) sb.append(c);
		
		System.out.println(sb);
		br.close();
	}
}
