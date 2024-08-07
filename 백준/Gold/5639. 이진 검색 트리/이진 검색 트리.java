import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static class Node {
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
            left = null;
            right = null;
        }
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.num).append("\n");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine());
        Node root = new Node(value);

        while (true) {
            String temp = br.readLine();
            if (temp == null || temp.isEmpty()) break;
            value = Integer.parseInt(temp);

            Node node = root;
            while (true) {
                if (value < node.num) {
                    if (node.left == null) {
                        Node newNode = new Node(value);
                        node.left = newNode;
                        break;

                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.right == null) {
                        Node newNode = new Node(value);
                        node.right = newNode;
                        break;

                    } else {
                        node = node.right;
                    }
                }
            }
        }
        postOrder(root);
        System.out.println(sb);
        br.close();
    }
}
