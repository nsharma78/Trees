/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.
Analysis
This problem can be illustrated by using a simple example.
in-order:   6 4 2 5  (1) 7 3 8
post-order: 6 4 5 2  7 8 3  (1)
From the post-order array, we know that last element is the root. We can find the root in in-order array. Then we can identify the left and right sub-trees of the root from in-order array.
Using the length of left sub-tree, we can identify left and right sub-trees in post-order array. Recursively, we can build up the tree.
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

public class CreateTreeFromInOrderAndPostOrderTraversal {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,8,6};
        Node root = TreeUtils.insertLevelOrder(arr, null, 0);
        System.out.println("========LevelOrderTraversal=========");
        List<List<Integer>> list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list);

        System.out.println("\n=====InOrder=====");
        PreOrderInOrderPostOrderTraversal.inOrderTraversal(root);

        System.out.println("\n=====PostOrder=====");
        PreOrderInOrderPostOrderTraversal.postOrderTraversal(root);

        int[] inOrder = {6,4,2,5,1,7,3,8};
        int[] postOrder = {6,4,5,2,7,8,3,1};

        root = createTree(inOrder, postOrder);
        list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println("\n" + list);

    }

    private static Node createTree(int[] inOrder, int[] postOrder) {
        int inStart = 0;
        int inEnd = inOrder.length - 1;
        int postStart = 0;
        int postEnd = postOrder.length - 1;

        return createTree(inOrder, inStart, inEnd, postOrder, postStart, postEnd);
    }

    private static Node createTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd)
            return null;

        int rootValue = postOrder[postEnd];
        Node root = new Node(rootValue);

        int k = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                k = i;
                break;
            }
        }

        root.left = createTree(inOrder, inStart, k - 1, postOrder, postStart, postStart + k - (inStart + 1));

        root.right = createTree(inOrder, k + 1, inEnd, postOrder, postStart + k- inStart, postEnd - 1);

        return root;
    }
}
