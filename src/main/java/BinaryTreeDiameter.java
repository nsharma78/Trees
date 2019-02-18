/*
 * The diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
 * Examples:
Input :     1
          /   \
        2      3
      /  \
    4     5
Output : 4 (4->2->1->3)
Input :     1
          /   \
        2      3
      /  \ .    \
    4     5 .    6
Output : 5 (4->2->1->3->6)
 */

package main.java;
import main.java.TreeUtils.Node;
import java.util.*;

public class BinaryTreeDiameter {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Node root = TreeUtils.insertLevelOrder(arr, null, 0);
        System.out.println("========LevelOrderTraversal=========");
        List<List<Integer>> list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list.toString());

        System.out.println("The diameter of the given tree is; " + diameter(root));

    }

    private static int diameter(Node root) {
        /* base case if tree is empty */
        if (root == null)
            return 0;

        /* get the height of left and right sub trees */
        int lheight = height(root.left);
        int rheight = height(root.right);

        /* get the diameter of left and right subtrees */
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));

    }

    private static int height(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }
}
