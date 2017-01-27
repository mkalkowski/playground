package hackerrank;

import java.util.LinkedList;
import java.util.List;

public class IsThisBST {

    public static void main(String[] args) {
        new IsThisBST().run();
    }

    void run() {

        Node n5 = new Node(5);
        Node n2 = new Node(2);
        Node n1 = new Node(1);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        n5.right = n8;
        n5.left = n2;
        n2.left = n1;
        n8.right = n9;
        n9.right = n1;

        System.out.println(checkBST(n5));
//        System.out.println(checkBST(n1));
//        System.out.println(checkBST(n2));
//        System.out.println(checkBST(n8));
//        System.out.println(checkBST(n9));
    }

    boolean checkBST(Node root) {

        List<Node> path = new LinkedList<>();

        path = inorder(root);

        System.out.println(path);
        for (int i = 1; i < path.size(); i++) {
            if (path.get(i).data <= path.get(i-1).data) return false;
        }
        return true;
    }

    private List<Node> inorder(Node root) {

        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Node> path = new LinkedList<>();
        Node current = root;

        do {
            stack.add(current);

            if (current.left != null) {
                current = current.left;
            } else {
                path.add(current);
                if (current.right != null) {
                    current = current.right;
                } else {
                    current = stack.pop();
                }
            }

        }while (!stack.isEmpty());
        return path;
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int i) {
            this.data = i;
        }

        public Node(int i, Node l, Node r) {
            this.data = i;
            this.left = l;
            this.right = r;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }
}
