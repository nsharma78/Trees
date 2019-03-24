/*
 * Given a binary tree, flatten it to a linked list in-place.
For example,
Given
         1
        / \
       2   5
      / \  / \
     3  4  6  7
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
              \
               7
 */


package main.java;
import java.util.*;
import main.java.TreeUtils.Node;

public class FlattenTreeToList {

    public static void main(String[] args) {
        int[] arr = {1,2,5,3,4,6,7};
        Node root = TreeUtils.insertLevelOrder(arr, null, 0);
        System.out.println("========LevelOrderTraversalForTree=========");
        List<List<Integer>> list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list);

        flattenTreeToList1(root);
        System.out.println("========LevelOrderTraversalForTreeAfterFlattening=========");
        list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list);

        flattenTreeToList2(root);
        System.out.println("========LevelOrderTraversalForTreeAfterFlattening=========");
        list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list);
    }

    private static void flattenTreeToList1(Node root) { // Uses extra memory
        if(root == null)
            return;
        Node node = root;
        Stack<Node> stk = new Stack<>();

        while(!stk.isEmpty() || node != null) {

            if(node.right != null){
                stk.push(node.right);
            }
            if(node.left != null) {
                node.right = node.left;
                node.left = null;
            }
            else if(!stk.empty()){
                Node temp = stk.pop();
                node.right=temp;
            }

            node = node.right;
        }
    }

    private static void flattenTreeToList2(Node root) { // No extra memory
        if (root == null || root.left == null && root.right == null) {
            return;
        }

        if (root.left != null) {
            flattenTreeToList2(root.left);

            Node tmpRight = root.right;
            root.right = root.left;
            root.left = null;
            Node t = root.right;

            while (t.right != null) {
                t = t.right;
            }
            t.right = tmpRight;
        }
        flattenTreeToList2(root.right);
    }
}
