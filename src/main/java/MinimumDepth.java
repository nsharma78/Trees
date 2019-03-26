/*
 * Given a binary tree, find its minimum depth.
 *  The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *  For this example, the minimum depth will be 3:
              1
             / \
            2   3
           /\  / \
          4  5 7  8
         /
        6
 */

package main.java;
import java.util.*;
import main.java.TreeUtils.Node;

public class MinimumDepth {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,7,8,6};
        Node root = TreeUtils.insertLevelOrder(arr, null, 0);
        System.out.println("========LevelOrderTraversal=========");
        List<List<Integer>> list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list.toString());

        System.out.println("The minimum depth for the given tree is: " + minDepth(root));
    }

    private static int minDepth(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
