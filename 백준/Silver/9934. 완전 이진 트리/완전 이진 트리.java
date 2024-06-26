import java.util.*;
import java.io.*;

public class Main {

    static int size;
    static int[] arr;
    static StringBuilder[] result;

    static void searchNode(int start, int end, int depth) {
        if (start > end) return;
        int mid = (start + end) / 2;

        result[depth].append(arr[mid]).append(" ");

        searchNode(start, mid-1, depth+1);
        searchNode(mid+1, end, depth+1);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        result = new StringBuilder[K];
        for (int i = 0; i < K; i++){
            result[i] = new StringBuilder();
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        size = (int)Math.pow(2, K) - 1;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        searchNode(0, size-1, 0);
        for (StringBuilder sb : result) System.out.println(sb);

        br.close();
    }
}
