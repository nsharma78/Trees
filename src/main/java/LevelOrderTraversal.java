/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree {1,2,3,4,5,6,7,8,9},
           1
       2       3
    4    5   6    7
  8   9
return its reverse level order traversal as [[1], [2,3], [4,5,6,7], [8,9]]
 * ----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(n) -- space O(n)
 */

package main.java;
import main.java.TreeUtils.Node;
import java.util.*;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node root = TreeUtils.sortedArrayToBST(arr, 0, arr.length - 1);
        System.out.println("========LevelOrderTraversalForBST=========");
        List<List<Integer>> list = levelOrderTraversal(root);
        System.out.println(list.toString());

        System.out.println("========LevelOrderTraversalForInsertLevelOrder=========");
        root = TreeUtils.insertLevelOrder(arr, null, 0);
        list = levelOrderTraversal(root);
        System.out.println(list.toString());
    }

    public static List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<Node> q = new LinkedList<>();
        if(root != null)
            q.add(root);

        Node temp = null;

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0) {
                temp = q.remove();
                list.add(temp.data);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            result.add(list);

        }

        return result;
    }
}
