/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.
Analysis
Consider the following example:
in-order: 6 4 2 5  (1) 7 3 8
pre-order: (1) 2 4 6  5 3 7 8
From the pre-order array, we know that first element is the root. We can find the root in in-order array. Then we can identify the left and right sub-trees of the root from in-order array.
Using the length of left sub-tree, we can identify left and right sub-trees in pre-order array. Recursively, we can build up the tree.
For this example, the constructed tree is:
              1
             / \
            2   3
           /\  / \
          4  5 7  8
         /
        6
 */

package main.java;
import main.java.TreeUtils.Node;
import java.util.*;

public class CreateTreeFromInOrderAndPreOrderTraversal {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,7,8,6};
        Node root = TreeUtils.insertLevelOrder(arr, null, 0);
        System.out.println("========LevelOrderTraversal=========");
        List<List<Integer>> list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list);

        System.out.println("\n=====InOrder=====");
        PreOrderInOrderPostOrderTraversal.inOrderTraversal(root);

        System.out.println("\n=====PreOrder=====");
        PreOrderInOrderPostOrderTraversal.preOrderTraversal(root);

        int[] inOrder = {6,4,2,5,1,7,3,8};
        int[] preOrder = {1,2,4,6,5,3,7,8};

        root = createTree(inOrder, preOrder);
        list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println("\n\n" + list);

    }

    private static Node createTree(int[] inOrder, int[] preOrder) {
        int inStart = 0;
        int inEnd = inOrder.length - 1;
        int preStart = 0;
        int preEnd = preOrder.length - 1;


        return createTree(preOrder, preStart, preEnd, inOrder, inStart, inEnd);
    }

    private static Node createTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        int rootValue = preOrder[preStart];
        Node root = new Node(rootValue);

        int k = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                k = i;
                break;
            }
        }

        root.left = createTree(preOrder, preStart+1, preStart+(k-inStart), inOrder, inStart, k-1);

        root.right = createTree(preOrder, preStart+(k-inStart)+1, preEnd, inOrder, k+1 , inEnd);

        return root;
    }
}
