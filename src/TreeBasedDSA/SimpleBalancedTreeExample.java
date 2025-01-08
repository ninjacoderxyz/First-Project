package TreeBasedDSA;

// Simple Node class for the Binary Tree
class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        left = right = null;
    }
}

// Binary Tree class
class BalancedBinaryTree {
    // Function to create a balanced binary tree from a sorted array
    Node createBalancedTree(int[] arr, int start, int end) {
        if (start > end) {
            return null; // Base case: No more elements to add
        }

        // Find the middle element
        int mid = (start + end) / 2;

        // Create a new node with the middle element
        Node node = new Node(arr[mid]);

        // Recursively create the left and right subtrees
        node.left = createBalancedTree(arr, start, mid - 1);
        node.right = createBalancedTree(arr, mid + 1, end);

        return node;
    }

    // Function to print the tree in-order
    void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
        }
    }
}

// Main class
public class SimpleBalancedTreeExample {
    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();

        // Input array (sorted to create a balanced tree)
        int[] input = {2, 3, 5, 10};

        // Create the balanced binary tree
        Node root = tree.createBalancedTree(input, 0, input.length - 1);

        // Print the in-order traversal of the tree
        System.out.println("In-order Traversal of the Balanced Binary Tree:");
        tree.inOrderTraversal(root);
    }
}