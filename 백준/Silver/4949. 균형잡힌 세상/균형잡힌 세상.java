import java.io.*;
import java.util.*;

public class Main {
	
	static Map<Character, Character> match = new HashMap<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		match.put(')', '(');
		match.put(']', '[');
		
		while(true) {
			String str = br.readLine();
			ArrayDeque<Character> q = new ArrayDeque<>();
			if (str.charAt(0) == '.') break;
			int size = str.length();
			boolean status = true;
			
			for (int i = 0; i < size; i++) {
				char value = str.charAt(i);
				if (value == '(' || value == '[') q.push(value);
				else if (value == ')' || value == ']') {
					if (q.peek() == match.get(value)) q.pop();
					else {
						status = false;
						break;
					}
				}
			}
			if (!q.isEmpty()) status = false;
			
			if (status) sb.append("yes").append("\n");
			else sb.append("no").append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
