import java.util.*;
import java.io.*;

public class Main {

    static Node[] nodes;
    static ArrayList<Integer>[] list;
    static int[] size;

    static class Node {

        ArrayList<Integer> childs;

        public Node() {
            this.childs = new ArrayList<>();
        }
    }

    static void makeTree(int currentNode, int parent) {
        for (Integer child : list[currentNode]) {
            if (child != parent) {
                nodes[currentNode].childs.add(child);
                makeTree(child, currentNode);
            }
        }
    }

    static void countSubtreeNodes(int startNode) {
        size[startNode] = 1;
        for (Integer child : nodes[startNode].childs) {
            countSubtreeNodes(child);
            size[startNode] += size[child];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        nodes = new Node[N + 1];
        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new Node();
        }
        makeTree(R, -1);

        size = new int[N + 1];
        countSubtreeNodes(R);

        for (int i = 0; i < Q; i++) {
            System.out.println(size[Integer.parseInt(br.readLine())]);
        }
        br.close();
    }
}
