import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static class Node{
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void insertNode(Node root, char value, char left, char right) {
        if (root.value == value) {
            if (left != '.'){
                root.left = new Node(left);
            }
            if (right != '.') {
                root.right = new Node(right);
            }
        } else {
            if (root.left != null) insertNode(root.left, value, left, right);
            if (root.right != null) insertNode(root.right, value, left, right);
        }
    }

    public static void preOrder(Node root) {
        if (root.value != '.') sb.append(root.value);
        if (root.left != null) preOrder(root.left);
        if (root.right != null) preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root.left != null) inOrder(root.left);
        if (root.value != '.') sb.append(root.value);
        if (root.right != null) inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root.left != null) postOrder(root.left);
        if (root.right != null) postOrder(root.right);
        if (root.value != '.') sb.append(root.value);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Node head = new Node('A');
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(head, value, left, right);
        }
        preOrder(head);
        sb.append("\n");
        inOrder(head);
        sb.append("\n");
        postOrder(head);
        System.out.println(sb);
        br.close();
    }
}
