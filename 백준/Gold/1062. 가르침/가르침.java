import java.util.*;
import java.io.*;

public class Main {
	
	static int N, K, maxCount = 0, maxDepth;
	static char[] a;
	static String[] str;
	static Set<Character> word = new HashSet<>(Arrays.asList('a', 'n', 't', 'i', 'c'));
	static Set<Character> newWord = new HashSet<>();
	
	static void check(int depth, int start) {

		if (depth == maxDepth) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				boolean status = true;
				for (int j = 4; j < str[i].length()-4;j++) {
					if (!word.contains(str[i].charAt(j))) {
						status = false;
						break;
					}
				}
				if (status) {
					count++;
				}
			}
			maxCount = Math.max(maxCount, count);
			return;
		}
		
		for (int i = start; i < newWord.size(); i++) {
			word.add(a[i]);
			check(depth+1, i+1);
			word.remove(a[i]);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
			for (int j = 4; j < str[i].length()-4; j++) newWord.add(str[i].charAt(j));
		}
		
		newWord.removeAll(word);
		a = new char[newWord.size()];

		int size = 0;
		for (Character c : newWord) a[size++] = c;
		
		if (K < 5) System.out.println(0);
		else if (K == 26) System.out.println(N);
		else {
			if (newWord.size() < K - 5) maxDepth = newWord.size();
			else maxDepth = K - 5;
			
			check(0, 0);
			System.out.println(maxCount);			
		}
		br.close();
	}
}