import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, l, r;
    static int[][] graph;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {
            boolean isNext = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;
                    if (find(i, j)) isNext = true;
                }
            }
            if (!isNext) break;
            count++;
        }

        System.out.println(count);
        br.close();
    }

    private static boolean find(int x, int y) {
        ArrayList<int[]> next = new ArrayList<>();
        int totalValue = graph[x][y];
        next.add(new int[]{x, y});

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (isPossible(nx, ny)) {
                    if (visited[nx][ny]) continue;
                    if (isInclude(graph[temp[0]][temp[1]], graph[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        next.add(new int[]{nx, ny});
                        totalValue += graph[nx][ny];
                    }
                }
            }
        }
        if (move(next, totalValue)) return true;
        return false;
    }

    private static boolean isPossible(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private static boolean isInclude(int standard, int value) {
        int diff = Math.abs(standard - value);
        return diff >= l && diff <= r;
    }

    private static boolean move(ArrayList<int[]> moveList, int total) {
        if (moveList.size() == 1) return false;

        int totalCount = moveList.size();
        int changeValue = total / totalCount;

        for (int[] index : moveList) {
            int x = index[0];
            int y = index[1];
            graph[x][y] = changeValue;
        }
        return true;
    }
}