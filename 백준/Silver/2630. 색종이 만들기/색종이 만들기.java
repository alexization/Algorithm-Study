import java.io.*;
import java.util.*;

public class Main {

    static int N, blueCnt = 0, whiteCnt = 0;
    static int[][] board;

    static void divide(int sx, int ex, int sy, int ey) {
        boolean w = false, b = false;
        for (int i = sx; i < ex; i++) {
            for (int j = sy; j < ey; j++) {
                if (board[i][j] == 1) b = true;
                else w = true;
            }
        }
        if (b && w){
            divide(sx, (sx+ex)/2, sy, (sy+ey)/2); // 1사분면
            divide((sx+ex)/2, ex, sy, (sy+ey)/2); // 2사분면
            divide(sx, (sx+ex)/2, (sy+ey)/2, ey); // 3사분면
            divide((sx+ex)/2, ex, (sy+ey)/2, ey); // 4사분면
        }

        else if (b == false) whiteCnt++;
        else if (w == false) blueCnt++;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        divide(0, N, 0, N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
        br.close();
    }
}
