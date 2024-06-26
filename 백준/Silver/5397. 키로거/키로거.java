import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			ArrayDeque<Character> dq1 = new ArrayDeque<>();
			ArrayDeque<Character> dq2 = new ArrayDeque<>();
			StringBuilder sb = new StringBuilder();
			
			char[] words = br.readLine().toCharArray();
			for (char word : words) {
				
				if (word == '<') {
					if (!dq1.isEmpty()) dq2.offerFirst(dq1.pollLast());
				} else if (word == '>') {
					if (!dq2.isEmpty()) dq1.offerLast(dq2.pollFirst());
				} else if (word == '-') {
					if (!dq1.isEmpty()) dq1.pollLast();
				} else {
					dq1.offer(word);
				}
				
			}
			for (char a : dq1) sb.append(a);
			for (char b : dq2) sb.append(b);
			System.out.println(sb);
		}
		br.close();
	}
}
