/*
 * Given an array representing preorder traversal of BST, print its postorder traversal.
 * Examples
 * Pre = {40,30,35,80,100}
 * Post = {35,30,100,80,40}
 *
 * Pre = {40,30,32,35,80,90,100,120}
 * Post = {35,32,30,120,100,90,80,40}
 *
 * Pre = {7,9,6,1,4,2,3,40}
 * Post = Not Possible
 */

package main.java;

import main.java.TreeUtils.Node;

public class PreToPost {

    private static int preIndex;

    private static Node constructTreeUtil(int pre[], int key,
                                          int min, int max) {

        // Base case
        if (preIndex >= pre.length) {
            return null;
        }

        Node root = null;

        // If current element of pre[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max) {

            // Allocate memory for root of this subtree and increment *preIndex
            root = new Node(key);
            preIndex++;

            if (preIndex < pre.length) {

                // Contruct the subtree under root
                // All nodes which are in range {min .. key} will go in left
                // subtree, and first such node will be root of left subtree.
                root.left = constructTreeUtil(pre, pre[preIndex], min, key);

                // All nodes which are in range {key..max} will go in right
                // subtree, and first such node will be root of right subtree.
                root.right = constructTreeUtil(pre, pre[preIndex], key, max);
            }
        }

        return root;
    }

    private static Node constructTree(int pre[], int size) {
        preIndex = 0;
        return constructTreeUtil(pre, pre[0], Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

        int pre[] = new int[]{40,30,35,80,100};
        Node root = constructTree(pre, pre.length);
        System.out.println("PostOrder traversal of the constructed tree is ");
        PreOrderInOrderPostOrderTraversal.postOrderTraversal(root);
    }

}
