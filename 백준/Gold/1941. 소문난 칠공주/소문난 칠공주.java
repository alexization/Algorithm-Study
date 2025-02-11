import java.io.*;
import java.util.*;

public class Main {
    static char[][] board = new char[5][5];
    static int[] selected = new int[7];
    static int answer = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++) {
            String line = br.readLine();
            for(int j = 0; j < 5; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        combination(0, 0);

        System.out.println(answer);
    }

    static void combination(int start, int depth) {
        if(depth == 7) {
            if(check()) answer++;
            return;
        }

        for(int i = start; i < 25; i++) {
            selected[depth] = i;
            combination(i + 1, depth + 1);
        }
    }

    static boolean check() {
        int sCnt = 0;
        for(int i = 0; i < 7; i++) {
            int x = selected[i] / 5;
            int y = selected[i] % 5;
            if(board[x][y] == 'S') sCnt++;
        }

        if(sCnt < 4) return false;

        boolean[] visited = new boolean[7];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int connectedCount = 1;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            int curX = selected[current] / 5;
            int curY = selected[current] % 5;

            for(int i = 0; i < 7; i++) {
                if(visited[i]) continue;

                int nextX = selected[i] / 5;
                int nextY = selected[i] % 5;

                if(Math.abs(curX - nextX) + Math.abs(curY - nextY) == 1) {
                    queue.offer(i);
                    visited[i] = true;
                    connectedCount++;
                }
            }
        }

        return connectedCount == 7;
    }
}