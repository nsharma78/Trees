/*
Given a binary tree, return the vertical order traversal of its nodes values.

           1
         /   \
       2       3
     /  \     /  \
   4     5   6    7
  / \
 8   9

The output of print this tree vertically will be:
8
4
2 9
1 5 6
3
7
 * ----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(n) -- space O(n)
*/

package main.java;
import java.util.*;
import main.java.TreeUtils.Node;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node root = TreeUtils.insertLevelOrder(arr, null, 0);
        List<List<Integer>> result = verticalOrderTraversal(root);
        System.out.println(result.toString());
    }

    private static List<List<Integer>> verticalOrderTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        int minLevel = 0, maxLevel = 0, level = 0;
        Node temp = null;

        if(root != null) {
            nodeQueue.add(root);
            levelQueue.add(0);
        }

        while(!nodeQueue.isEmpty()) {

            temp = nodeQueue.remove();
            level = levelQueue.remove();

            if(!map.containsKey(level)) {
                List<Integer> list = new ArrayList<>();
                list.add(temp.data);
                map.put(level, list);
            }
            else {
                map.get(level).add(temp.data);
                map.put(level, map.get(level));
            }

            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);

            if(temp.left != null) {
                nodeQueue.add(temp.left);
                levelQueue.add(level - 1);
            }
            if(temp.right != null) {
                nodeQueue.add(temp.right);
                levelQueue.add(level + 1);
            }
        }

        for (int i = minLevel; i <= maxLevel; i++) {
            if(map.containsKey(i))
                result.add(map.get(i));
        }

        return result;
    }

}
