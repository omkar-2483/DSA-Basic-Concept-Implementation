package DSAProblems;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BST {
    Node root;

    public BST() {
        root = null;
    }
    
    //insert new Data
    public void insertNode(int data) {
        root = insertNode(root, new Node(data));
    }

    private Node insertNode(Node root, Node nodeToBeInserted) {
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
    
    //search data in tree
    public boolean searchNode(int key) {
        return searchNode(root, key);
    }

    private boolean searchNode(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        } else if (root.data < key) {
            return searchNode(root.right, key);
        } else {
            return searchNode(root.left, key);
        }
    }

    //delete data in tree
    public void deleteNode(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the in-order successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the in-order successor
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    //display tree
    public void displayBST() {
        displayBST(root);
        System.out.println();
    }

    private void displayBST(Node root) {
        if (root == null) {
            return;
        }
        displayBST(root.left);
        System.out.print(root.data + " ");
        displayBST(root.right);
    }
}

public class BSTOperations {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insertNode(5);
        tree.insertNode(3);
        tree.insertNode(7);
        tree.insertNode(1);
        tree.insertNode(4);
        tree.insertNode(6);
        tree.insertNode(8);

        tree.displayBST();

        int key = 8;
        System.out.println("Is " + key + " present in tree? " + tree.searchNode(key));

        tree.deleteNode(key);
        System.out.println("Tree after deleting " + key + ":");
        tree.displayBST();
    }
}