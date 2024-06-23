import java.util.*;
import java.io.*;

public class Main {
    static int minValue = 1_000_000_000;
    static int N, M, chickenCnt, homeCnt;
    static int[][] graph, C, H, check;
    static List<int[]> chickenInfo = new ArrayList<>();
    static List<int[]> homeInfo = new ArrayList<>();
    
    static void cal(int cnt, int start, int select) {
        // M개의 치킨집이 선정이 되면 수행
        if (select == M) {
            int distance = 0;
            // 모든 집들에 대해서 선택된 치킨집과의 거리중 최소 거리만을 distance 변수에 더해줌
            for (int[] homePos : H) {
                int minDist = 1_000_000_000;
                for (int[] cPos : check) {
                    minDist = Math.min(minDist, Math.abs(homePos[0] - cPos[0]) + Math.abs(homePos[1] - cPos[1]));
                }
                distance += minDist;
            }
            minValue = Math.min(minValue, distance);
            return;
        }
        if (cnt == chickenCnt) return;
        
        // 순서에 상관이 없기 때문에 조합을 사용
        for (int i=start; i<chickenCnt;i++) {
            check[select] = C[i];
            cal(cnt+1, i+1, select+1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        check = new int[M][2];

        // 그래프 그리기
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0;j<N;j++) {
                int value = Integer.parseInt(st.nextToken());
                // 총 몇개의 집과 치킨집이 있는지 모르기에 List 사용
                if (value == 1) homeInfo.add(new int[] {i, j});
                else if (value == 2) chickenInfo.add(new int[] {i,j});
                graph[i][j] = value;
            }
        }

        // 치킨집과 집의 개수
        chickenCnt = chickenInfo.size();
        homeCnt = homeInfo.size();

        // 치킨집과 집의 x, y 좌표 정보를 저장해줄 2차원 배열 생성 및 정보 저장
        C = new int[chickenCnt][2];
        H = new int[homeCnt][2];

        int size = 0;
        for (int[] temp:chickenInfo) C[size++] = temp;

        size = 0;
        for (int[] temp:homeInfo) H[size++] = temp;
        
        cal(0, 0, 0);
        System.out.println(minValue);

        br.close();
    }
}
