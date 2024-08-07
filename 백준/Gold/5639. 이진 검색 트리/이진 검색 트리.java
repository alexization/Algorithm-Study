import java.util.*;
import java.io.*;

public class Main {

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
        System.out.println(node.num);
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        Node root = new Node(value);

        while (sc.hasNext()) {
            value = sc.nextInt();
            
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
        sc.close();
    }
}
