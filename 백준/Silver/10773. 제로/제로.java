import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		int K = Integer.parseInt(br.readLine());
		for (int i=0; i<K; i++) {
			int value = Integer.parseInt(br.readLine());
			if (value == 0) {
				stack.pop(); 
				continue;
			}
			stack.push(value);
		}
		
		int result = 0;
		while (!stack.isEmpty()) result += stack.pop();
		
		System.out.println(result);
		br.close();
	}
	
}