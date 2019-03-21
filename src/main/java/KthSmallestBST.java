/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it. (1 ≤ k ≤ BST's total elements)
 *
 *----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(n) -- space O(n)
 */

package main.java;
import main.java.TreeUtils.Node;
import java.util.*;

public class KthSmallestBST {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node root = TreeUtils.sortedArrayToBST(arr, 0, arr.length - 1);
        TreeUtils.printBST(root);
        int k = 2;
        System.out.println("The Kth smallest in the give BST is: "  + kthSmallest(root, k));
    }

    private static int kthSmallest(Node root, int k) {
        int result = Integer.MIN_VALUE;
        if (root == null)
            return result;

        Stack<Node> stk = new Stack<>();
        Node node = root;
        while(node != null || !stk.isEmpty()) {

            if(node != null) {
                stk.push(node);
                node = node.left;

            }else {
                Node temp = stk.pop();
                k--;
                if(k == 0)
                    result = temp.data;
                node = temp.right;
            }

        }

        return result;
    }
}
