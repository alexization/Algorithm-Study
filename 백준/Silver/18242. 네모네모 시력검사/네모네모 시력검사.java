import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] graph = new char[N][M];
        boolean start = true;
        int sx = -1;
        int sy = -1;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j);
                if (start && str.charAt(j) == '#') {
                    sx = i;
                    sy = j;
                    start = false;
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int count = 0;
        while(true){
            sx += dx[count];
            sy += dy[count];
            if (0 <= sx && sx < N && 0 <= sy && sy < M) {
                if (graph[sx][sy] == '#') continue;
                int tempX = sx + dx[count];
                int tempY = sy + dy[count];
                if (0 > tempX || 0 > tempY || tempX >= N || tempY >= M){
                    sx -= dx[count];
                    sy -= dy[count];
                    count += 1;
                    continue;
                }
                if (graph[tempX][tempY] == '.') {
                    sx -= dx[count];
                    sy -= dy[count];
                    count += 1;
                } else {
                    break;
                }
            }
            else {
                sx -= dx[count];
                sy -= dy[count];
                count += 1;
            }
        }

        Map<Integer, String> result = new HashMap<>();
        result.put(0, "UP");
        result.put(1, "RIGHT");
        result.put(2, "DOWN");
        result.put(3, "LEFT");

        System.out.println(result.get(count));
        br.close();
    }
}
