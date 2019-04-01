/*
 * Two elements of a binary search tree (BST) are swapped by mistake. Recover the tree without changing its structure.
 */

package main.java;
import main.java.TreeUtils.Node;

public class RecoverBST {

    static Node first;
    static Node second;
    static Node pre;

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,4,6,7,8,9};
        Node root = TreeUtils.sortedArrayToBST(arr, 0, arr.length - 1);
        System.out.println(LevelOrderTraversal.levelOrderTraversal(root).toString());
        recoverBST(root);
        System.out.println(LevelOrderTraversal.levelOrderTraversal(root).toString());
    }

    private static void recoverBST(Node root) {
        if (root == null)
            return;

            inorder(root);
            if(second!=null && first !=null){
                int data = second.data;
                second.data = first.data;
                first.data = data;
            }

        }

        private static void inorder(Node root) {
            if(root==null)
                return;

            inorder(root.left);

            if(pre==null){
                pre=root;
            }else{
                if(root.data < pre.data){
                    if(first==null){
                        first=pre;
                    }

                    second=root;
                }
                pre=root;
            }

            inorder(root.right);

        }
}
