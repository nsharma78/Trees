/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * 	The left subtree of a node contains only nodes with keys less than the node's key.
 * 	The right subtree of a node contains only nodes with keys greater than the node's key.
 * 	Both the left and right subtrees must also be binary search trees.
 *
 * Ex
 *     4
     2   6
   1  3 5  7
   is BST but
       1
     2   3
   4  5 6  7
   is not BST
 * ----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(n) -- space O(1)
 */

package main.java;
import main.java.TreeUtils.Node;

public class ValidateBST {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node root = TreeUtils.sortedArrayToBST(arr, 0, arr.length - 1);

        boolean isValidBST = validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if(isValidBST)
            System.out.println("The given binary tree is a BST");
        else
            System.out.println("The given binary tree is NOT a BST");

        root = TreeUtils.insertLevelOrder(arr, null, 0);

        isValidBST = validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if(isValidBST)
            System.out.println("The given binary tree is a BST");
        else
            System.out.println("The given binary tree is NOT a BST");
    }

    private static boolean validateBST(Node root, int min, int max) {
        if(root == null)
            return true;

        if(root.data <= min || root.data >= max)
            return false;
        return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
    }
}
