/*
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * Example
 *     4
     2   6
   1  3 5  7

   LCA(1,3) is 2
   LCA(1,7) is 4
   LCA(1,2) is 2
 */


package main.java;
import main.java.TreeUtils.Node;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println("==========Create BST from sorted array and print tree==========");
        Node root = TreeUtils.sortedArrayToBST(arr, 0, arr.length - 1);
        TreeUtils.printBST(root);

        Node result = lowestCommonAncestor(root, new Node(1), new Node(3));
        if(result != null)
            System.out.println("The LCA for 1 and 3 is: " + result.data);

        result = lowestCommonAncestor(root, new Node(1), new Node(7));
        if(result != null)
            System.out.println("The LCA for 1 and 7 is: " + result.data);

        result = lowestCommonAncestor(root, new Node(1), new Node(2));
        if(result != null)
            System.out.println("The LCA for 1 and 2 is: " + result.data);

        result = lowestCommonAncestor(root, new Node(1), new Node(10));
        if(result != null)
            System.out.println("The LCA for 1 and 10 is: " + result.data);
    }

    private static Node lowestCommonAncestor(Node node, Node first, Node second) {
        if (node == null)
            return node;
        if(node.data == first.data || node.data == second.data)
            return node;

        Node l = lowestCommonAncestor(node.left, first, second);
        Node r = lowestCommonAncestor(node.right, first, second);

        if(l != null && r != null) {
            return node;
        }else if(l == null && r == null) {
            return null;
        }else {
            return (l == null) ? r : l;
        }
    }
}
