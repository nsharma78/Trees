/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree {1,2,3,4,5,6,7,8,9},
           1
       2       3
    4    5   6    7
  8   9
return its reverse level order traversal as [[8,9], [4,5,6,7], [2,3], [1]]
 * ----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(n) -- space O(n)
 */

package main.java;
import main.java.TreeUtils.Node;
import java.util.*;

public class ReverseLevelOrderTraversal {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node root = TreeUtils.sortedArrayToBST(arr, 0, arr.length - 1);
        System.out.println("========ReverseLevelOrderTraversalForBST=========");
        List<List<Integer>> list = reverseLevelOrderTraversal(root);
        for(int i = list.size() - 1; i >= 0; --i)
            System.out.println(list.get(i).toString());

        System.out.println("========ReverseLevelOrderTraversalForInsertLevelOrder=========");
        root = TreeUtils.insertLevelOrder(arr, null, 0);
        list = reverseLevelOrderTraversal(root);
        for(int i = list.size() - 1; i >= 0; --i)
            System.out.println(list.get(i).toString());
    }

    private static List<List<Integer>> reverseLevelOrderTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<Node> queue = new LinkedList<>();
        Node temp = null;
        int size = 0;
        if(root != null)
            queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            size = queue.size();
            while (size-- > 0) {
                temp = queue.remove();
                list.add(temp.data);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            result.add(list);

        }

        return result;
    }
}
