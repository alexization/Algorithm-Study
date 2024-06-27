import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int remain = 1000 - N;
		int[] money = {500, 100, 50, 10, 5, 1};
		
		int count = 0;
		for (int m : money) {
			if (remain >= m) {
				count += remain / m;
				remain %= m;
			}
		}
		
		System.out.println(count);
		br.close();
	}
}
