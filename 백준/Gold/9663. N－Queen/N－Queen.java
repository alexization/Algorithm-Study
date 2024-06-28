import java.util.*;
import java.io.*;

public class Main {

	static int N, ans, col[];
	
	static boolean isAvailable(int rowNo) {
		for (int j=0;j<rowNo;j++) {
			// 두 위치가 같은 수직선 상에 있는지 같은 대각선 상에 있는지 검증
			if (col[rowNo] == col[j] || Math.abs(col[rowNo] - col[j]) == rowNo - j) return false;
		}
		return true;
	}
	
	static void nqueen(int rowNo) {
		if (!isAvailable(rowNo - 1)) return;
		if (rowNo == N) {
			ans++;
			return;
		}
		for (int i = 0; i < N; i++) {
			col[rowNo] = i;
			nqueen(rowNo+1);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];
		ans = 0;
		nqueen(0);
		
		System.out.println(ans);
		sc.close();
	}
}