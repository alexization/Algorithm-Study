import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] g = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                g[i][j] = str.charAt(j) - '1';
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int[][] v = new int[N][M];
        int depth = 0;
        Map<Integer, Integer> calMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (v[i][j] == 0 && g[i][j] == -1){
                    depth++;
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    v[i][j] = depth;

                    int count = 1;
                    while (!q.isEmpty()) {
                        int[] temp = q.poll();
                        int x = temp[0];
                        int y = temp[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                                if (v[nx][ny] != 0) continue;
                                if (g[nx][ny] == -1){
                                v[nx][ny] = depth;
                                count++;
                                q.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    calMap.put(depth, count);
                }
            }
        }
        
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (g[i][j] == 0) {
                    Set<Integer> tempSet = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                            if (v[nx][ny] != 0){
                                tempSet.add(v[nx][ny]);
                            }
                        }
                    }
                    Integer[] tempArr = tempSet.toArray(new Integer[0]);
                    int count = 1;
                    for (Integer value : tempArr) count += calMap.get(value);
                    result[i][j] = count;
                }
                else {
                    result[i][j] = 0;
                }
            }
        }

        for (int[] r : result) {
            for (int a : r) System.out.print(a % 10);
            System.out.println();
        }

        br.close();
    }
}
