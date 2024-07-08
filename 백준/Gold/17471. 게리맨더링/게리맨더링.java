import java.util.*;
import java.io.*;

public class Main {
	
	static int N, minValue = Integer.MAX_VALUE;
	static int[] people;
	static List<ArrayList<Integer>> g = new ArrayList<>();
	
	static int find(Integer[] left) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[N+1];
		q.offer(left[0]);
		v[left[0]] = true;
		int count = people[left[0]];
		
		while (!q.isEmpty()) {
			int idx = q.poll();
			for (int next : g.get(idx)) {
				for (int i = 0; i < left.length; i++) {
					if (left[i] == next) {
						if (v[next]) continue;
						v[next] = true;
						count += people[next];
						q.offer(next);
					}
				}
			}
		}
		for (int idx : left) {
			if (v[idx] == false) return -1;
		}
		return count;
	}
	
	static void comb(int cnt, Set<Integer> left) {
		if (cnt == N + 1) {
			Set<Integer> rightSet = new HashSet<>();
			for (int i = 1; i < N+1; i++) rightSet.add(i);
			rightSet.removeAll(left);
			
			if (rightSet.isEmpty() || left.isEmpty()) return;
			
			int leftValue = find(left.toArray(new Integer[left.size()]));
			int rightValue = find(rightSet.toArray(new Integer[rightSet.size()]));
			
			if (leftValue == -1 || rightValue == -1) return;
			minValue = Math.min(minValue, Math.abs(leftValue - rightValue));
			return;
		}
		
		left.add(cnt);
		comb(cnt + 1, left);
		left.remove(cnt);
		comb(cnt + 1, left);
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		people = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N + 1; i++) g.add(new ArrayList<>());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			for (int j = 0; j < c; j++) {
				g.get(i+1).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		Set<Integer> leftSet = new HashSet<>();
		comb(1, leftSet);
		
		if (minValue == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minValue);
		br.close();
	}
}