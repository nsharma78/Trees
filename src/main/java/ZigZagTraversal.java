/*
 * Given a binary tree of size N, your task is to complete the function zigZagTraversal(), that prints the nodes of binary tree in ZigZag manner.
For Example:
For the below binary tree the zigzag order
traversal will be 1 2 3 4 5 6 7.
        1
      /   \
    2       3
  /  \     /  \
 7    6   5    4

 */
package main.java;

import java.util.Stack;

import main.java.TreeUtils.Node;

public class ZigZagTraversal {

    public static void main(String[] args) {
        int[] arr = {1,2,3,7,6,5,4};

        Node root = TreeUtils.insertLevelOrder(arr, null, 0);
        System.out.println("The level order tracersal is: " + LevelOrderTraversal.levelOrderTraversal(root).toString());
        System.out.println("The zigzag tracersal is: ");
        zigZag(root);
    }

    private static void zigZag(Node node) {
        if (node == null)
            return;   // NULL check

        // Create two stacks to store alternate levels
        Stack<Node> rightStk = new Stack<Node>();// For levels to be printed from right to left
        Stack<Node> leftStk = new Stack<Node>();// For levels to be printed from left to right

        // Push first level to first stack 'rightStk'
        rightStk.push(node);

        // Keep printing while any of the stacks has some nodes
        while (!rightStk.empty() || !leftStk.empty())
        {
            // Print nodes of current level from rightStk and push nodes of
            // next level to leftStk
            while (!rightStk.empty())
            {
                Node temp = rightStk.pop();
                System.out.print(temp.data + " ");

                // Note that it is right which is pushed before left
                if (temp.right != null)
                    leftStk.push(temp.right);

                if (temp.left != null)
                    leftStk.push(temp.left);

            }

            // Print nodes of current level from leftStk and push nodes of
            // next level to rightStk
            while (!leftStk.empty())
            {
                Node temp = leftStk.pop();
                System.out.print(temp.data + " ");

                // Note that it is left which is pushed before right
                if (temp.left != null)
                    rightStk.push(temp.left);
                if (temp.right != null)
                    rightStk.push(temp.right);
            }
        }
    }

}
