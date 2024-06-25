import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		int value = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			value = Integer.parseInt(st.nextToken());
			if (st.countTokens() == 1) {
				stack.push(Integer.parseInt(st.nextToken())); continue;
			}
			
			if (value == 2) {
				if (!stack.isEmpty()) sb.append(stack.pop()).append("\n");
				else sb.append(-1).append("\n");
				
			} else if (value == 3) {
				sb.append(stack.size()).append("\n");
				
			} else if (value == 4) {
				if (stack.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				
			} else {
				if (stack.isEmpty()) sb.append(-1).append("\n");
				else sb.append(stack.peek()).append("\n");
			}
			
		}
		System.out.println(sb);
		br.close();
	}
}
