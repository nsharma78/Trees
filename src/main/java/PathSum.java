/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
           4     8
          / \    / \
        11   6  13  4
       /  \  /
      7    2 1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

package main.java;
import main.java.TreeUtils.Node;
import java.util.List;

public class PathSum {

    public static void main(String[] args) {
        int[] arr = {5,4,8,11,6,13,4,7,2,1};
        Node root = TreeUtils.insertLevelOrder(arr, null, 0);
        System.out.println("========LevelOrderTraversal=========");
        List<List<Integer>> list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list);

        int sum = 22;
        boolean hasPath = hasPathSum(root, sum);

        if(hasPath)
            System.out.println("There is path with sum: " + sum + " exists in the given tree");
        else
            System.out.println("There is NO path with sum: " + sum + " exists in the given tree");
    }

    private static boolean hasPathSum(Node root, int sum) {
        if (root == null)
            return false;

        if (root.data == sum && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }
}
