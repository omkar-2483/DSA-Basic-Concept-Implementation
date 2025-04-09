import java.util.Scanner;
import java.util.Stack;


class Node {
    int data;
    Node right;
    Node left;

    public Node(int data) {
        this.data = data;
        right = null;
        left = null;
    }

    public Node() {
        right = null;
        left = null;
    }
}

public class TreeTraversalUsingExplicitStack {
    // function to insert new Data
    public static Node insertNode(Node root, Node nodeToBeInserted) {
        if (root == null) {
            return nodeToBeInserted;
        }
        if (root.data > nodeToBeInserted.data) {
            root.left = insertNode(root.left, nodeToBeInserted);
        } else if (root.data < nodeToBeInserted.data) {
            root.right = insertNode(root.right, nodeToBeInserted);
        }
        return root;
    }


    // in-order traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        Node currentNode = root;
        while (!s.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                Node n = s.pop();
                System.out.print(n.data + " ");
                currentNode = n.right;
            }
        }
    }

    // pre-order traversal
    public static void preorder(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            System.out.print(currentNode.data + " ");

            // Push right child first, then left child,
            // to ensure left child is processed before right child (as in pre-order traversal).
            if (currentNode.right != null)
                stack.push(currentNode.right);
            if (currentNode.left != null)
                stack.push(currentNode.left);
        }
    }

    // post-order traversal
    public static void postorder(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Stack<Node> output = new Stack<>();

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            output.push(currentNode);

            if (currentNode.left != null)
                stack.push(currentNode.left);
            if (currentNode.right != null)
                stack.push(currentNode.right);
        }

        while (!output.isEmpty()) {
            System.out.print(output.pop().data + " ");
        }
    }

    // main class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(5);
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter data: ");
            int data = sc.nextInt();
            Node node=new Node(data);
            root = insertNode(root, node);
        }
        System.out.print("InOrder Traversal: ");
        inorder(root);
        System.out.println();
        System.out.print("PreOrder Traversal: ");
        preorder(root);
        System.out.println();
        System.out.print("PostOrder Traversal: ");
        postorder(root);
        sc.close();
    }
}