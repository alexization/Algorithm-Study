import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs = new String[5];
		
		int maxSize = -1;
		for (int i=0;i<5;i++) {
			strs[i] = br.readLine();
			maxSize = Math.max(maxSize, strs[i].length());
		}
		
		for (int i=0;i<maxSize;i++) {
			for (int j=0;j<5;j++) {
				if (strs[j].length() < i+1) continue;
				sb.append(strs[j].charAt(i));
			}
		}
		System.out.println(sb);
		br.close();
	}
}
