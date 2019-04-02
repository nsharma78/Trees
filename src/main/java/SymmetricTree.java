/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
 /\   /
4  3 3
*/

package main.java;
import main.java.TreeUtils.Node;
import java.util.*;

public class SymmetricTree {

    public static void main(String[] args) {
        int[] arr = {1,2,2,4,3,3};
        Node root = TreeUtils.insertLevelOrder(arr, null, 0);
        System.out.println("========LevelOrderTraversal=========");
        List<List<Integer>> list1 = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list1);

        InvertBinaryTree.invertBinaryTree(root);
        List<List<Integer>> list2 = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list2);

        if(list1.equals(list2))
            System.out.println("Given tree is symmetrical");
        else
            System.out.println("Given tree is NOT symmetrical");

    }
}
