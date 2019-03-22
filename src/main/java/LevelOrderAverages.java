/*
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
 */

package main.java;
import main.java.TreeUtils.Node;
import java.util.*;

public class LevelOrderAverages {

    public static void main(String[] args) {
        int[] arr = {3,9,20,15,7};

        System.out.println("========LevelOrderTraversalForInsertLevelOrder=========");
        Node root = TreeUtils.insertLevelOrder(arr, null, 0);
        List<Double> list = levelOrderAverages(root);
        System.out.println(list.toString());
    }

    public static List<Double> levelOrderAverages(Node root) {
        List<Double> result = new ArrayList<Double>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp;

        while(!q.isEmpty()) {
            int size = q.size();
            int num = size;
            double sum = 0.0;
            while(size-- > 0) {
                temp = q.poll();
                sum += temp.data;
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            result.add(sum/num);
        }
        return result;
    }
}
