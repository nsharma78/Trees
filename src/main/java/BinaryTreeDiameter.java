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
        /*List<List<Integer>> list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list.toString());

        System.out.println("The diameter of the given tree is; " + diameter(root));*/

    }
}
