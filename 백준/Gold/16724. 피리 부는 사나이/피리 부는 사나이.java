import java.util.*;
import java.io.*;

public class Main {

    static int N, M, depth = 1, count = 0;
    static char[][] cmdArr;
    static int[][] v;
    static Map<Character, int[]> cmd = new HashMap<>();

    static void dfs(int x, int y) {
        v[x][y] = depth;
        int[] next = cmd.get(cmdArr[x][y]);
        int nx = x + next[0];
        int ny = y + next[1];

        if (v[nx][ny] == 0){
            dfs(nx, ny);
        } else {
          if (v[nx][ny] == depth){
              count++;
          }
          depth++;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cmd.put('D', new int[]{1, 0});
        cmd.put('L', new int[]{0, -1});
        cmd.put('R', new int[]{0, 1});
        cmd.put('U', new int[]{-1, 0});
        cmdArr = new char[N][M];
        v = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                cmdArr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (v[i][j] == 0){
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}