/*
 *   4
   /   \
  2     7
 / \   / \
1   3 6   9
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * ----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(n) -- space O(1)
 */

package main.java;
import main.java.TreeUtils.Node;
import java.util.*;

public class InvertBinaryTree {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,9};
        Node root = TreeUtils.sortedArrayToBST(arr, 0, arr.length - 1);
        System.out.println("========LevelOrderTraversalForBST=========");
        List<List<Integer>> list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list);

        invertBinaryTree(root);
        System.out.println("========LevelOrderTraversalForBST after Inverting========");
        list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list);

    }

    static void invertBinaryTree(Node root) {
        if (root == null)
            return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}
