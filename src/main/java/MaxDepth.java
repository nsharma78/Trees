/*
    Given a binary tree, find its maximum depth.
    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

package main.java;
import main.java.TreeUtils.Node;

public class MaxDepth {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node root = TreeUtils.sortedArrayToBST(arr, 0, arr.length - 1);
        TreeUtils.printBST(root);
        System.out.println("The maxz depth of the tree is: " + maxDepth(root));
    }

    private static int maxDepth(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
