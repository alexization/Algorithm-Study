import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] graph = new int[9][9];
	static ArrayList<int[]> check = new ArrayList<>();
	static int count;
	static int[][] info;
	
	static boolean checkRow(int x, int value) {
		for (int i = 0; i < 9; i++) {
			if (value == graph[x][i]) return true;
		}
		return false;
	}
	
	static boolean checkCol(int y, int value) {
		for (int i = 0; i < 9; i++) {
			if (value == graph[i][y]) return true;
		}
		return false;
	}
	
	static boolean checkSquare(int x, int y, int value) {
		x = (x / 3) * 3;
		y = (y / 3) * 3;
		
		for (int i = x; i < x+3; i++) {
			for (int j = y; j < y+3; j++) {
				if (value == graph[i][j]) return true;
			}
		}
		
		return false;
	}
	
	static void sudoqu(int depth) {
		if (depth == count) {
			for (int[] g : graph) {
				for (int v : g) System.out.print(v + " ");
				System.out.println();
			}
			
			System.exit(0);
		}
		
		for (int i = 1; i<10; i++) {
			if (checkRow(info[depth][0], i)) continue;
			if (checkCol(info[depth][1], i)) continue;
			if (checkSquare(info[depth][0], info[depth][1], i)) continue;
			
			graph[info[depth][0]][info[depth][1]] = i;
			sudoqu(depth+1);
			graph[info[depth][0]][info[depth][1]] = 0;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int value = 0;
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				value = Integer.parseInt(st.nextToken());
				if (value == 0) check.add(new int[] {i, j});
				graph[i][j] = value;
			}
		}
		count = check.size();
		info = new int[count][2];
		int size = 0;
		for (int[] temp:check) info[size++] = temp;
		
		sudoqu(0);
		br.close();
	}
}
