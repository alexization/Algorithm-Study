import java.util.*;
import java.io.*;

public class Main {

    static Node rootNode = new Node();

    static class Node {
        Node[] childs;
        ArrayList<Integer> outPuts;
        Node failLink;

        public Node() {
            childs = new Node[26];
            outPuts = new ArrayList<>();
            failLink = null;
        }
    }

    static void makeTrie(String pattern, int index) {

        Node node = rootNode;
        for (int i = 0; i < pattern.length(); i++) {
            int c = pattern.charAt(i) - 'a';
            if (node.childs[c] == null) {
                node.childs[c] = new Node();
            }

            node = node.childs[c];
        }
        node.outPuts.add(index);
    }

    static void makeFailure() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (rootNode.childs[i] != null) {
                rootNode.childs[i].failLink = rootNode;
                q.offer(rootNode.childs[i]);
            } else {
                rootNode.childs[i] = rootNode;
            }
        }

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int i = 0; i < 26; i++) {
                if (curr.childs[i] != null) {
                    Node failLink = curr.failLink;

                    while (failLink.childs[i] == null && failLink != rootNode) {
                        failLink = failLink.failLink;
                    }

                    if (failLink.childs[i] != null) {
                        curr.childs[i].failLink = failLink.childs[i];
                    } else {
                        curr.childs[i].failLink = rootNode;
                    }

                    curr.childs[i].outPuts.addAll(curr.childs[i].failLink.outPuts);
                    q.offer(curr.childs[i]);
                }
            }
        }
    }

    static boolean search(String text) {
        Node node = rootNode;
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i) - 'a';
            while (node.childs[c] == null && node != rootNode) {
                node = node.failLink;
            }

            node = node.childs[c];
            if (node == null) {
                node = rootNode;
            } else if (!node.outPuts.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());
        String[] patterns = new String[S];
        for (int i = 0; i < S; i++) {
            patterns[i] = br.readLine();
            makeTrie(patterns[i], i);
        }

        makeFailure();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            if (search(br.readLine())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        br.close();
    }
}