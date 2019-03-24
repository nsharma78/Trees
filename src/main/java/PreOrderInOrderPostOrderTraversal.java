/*
 * Create tree
 * Preorder traversal
 * Postorder traversal
 * Inorder traversal
 * ----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(n) -- space O(1)
 * 	In-order, Pre-order, and Post-order traversals are Depth-First traversals.
	For a Graph, the complexity of a Depth First Traversal is O(n + m), where n is the number of nodes, and m is the number of edges.
	Since a Binary Tree is also a Graph, the same applies here. The complexity of each of these Depth-first traversals is O(n+m).
	Since the number of edges that can originate from a node is limited to 2 in the case of a Binary Tree, the maximum number of total edges in a Binary Tree is n-1, where n is the total number of nodes.
	The complexity then becomes O(n + n-1), which is O(n).
 */

package main.java;
import main.java.TreeUtils.Node;

public class PreOrderInOrderPostOrderTraversal {

    public static void main(String[]  args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node root = sortedArrayToBST(arr, 0, arr.length - 1);
        System.out.println("=====PreOrder=====");
        preOrderTraversal(root);

        System.out.println("\n=====InOrder=====");
        inOrderTraversal(root);

        System.out.println("\n=====PostOrder=====");
        postOrderTraversal(root);
    }

    public static Node sortedArrayToBST(int[] arr, int start, int end) {

        // Base case
        if(start > end)
            return null;

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);
        return root;
    }

    public static void preOrderTraversal(Node root) {
        if(root == null)
            return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root) {
        if(root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root) {
        if(root == null)
            return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
}
