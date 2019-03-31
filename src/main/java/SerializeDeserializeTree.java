/*
 * Design an algorithm to serialize and de-serialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 */

package main.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.TreeUtils.Node;

public class SerializeDeserializeTree {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Node root = TreeUtils.insertLevelOrder(arr, null, 0);
        System.out.println("========LevelOrderTraversal=========");
        List<List<Integer>> list = LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println(list.toString());

        String str = serialize(root);

        Node newRoot = desrialize(str);

        System.out.println("========LevelOrderTraversalAfterDeserializing=========");
        list = LevelOrderTraversal.levelOrderTraversal(newRoot);
        System.out.println(list.toString());
    }

    private static Node desrialize(String str) {
        if(str == null || str.length() == 0)
            return null;

        String[] nodes = str.split(":");
        Node root = new Node(Integer.parseInt(nodes[0]));
        Queue<Node> nodeQ = new LinkedList<>();
        Node curr = null;
        int i = 1;

        nodeQ.add(root);

        while(!nodeQ.isEmpty()) {
            curr = nodeQ.remove();
            if(curr == null)
                continue;

            if(nodes[i].equals("#")) {
                nodeQ.add(null);
                curr.left = null;
            }
            else {
                curr.left = new Node(Integer.parseInt(nodes[i]));
                nodeQ.add(curr.left);
            }
            ++i;

            if(nodes[i].equals("#")) {
                nodeQ.add(null);
                curr.right = null;
            }
            else {
                curr.right = new Node(Integer.parseInt(nodes[i]));
                nodeQ.add(curr.right);
            }
            ++i;
        }
        return root;
    }

    private static String serialize(Node root) {
        if(root == null)
            return null;
        Queue<Node> nodeQ = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Node curr = null;

        nodeQ.add(root);

        while(!nodeQ.isEmpty()) {
            curr = nodeQ.remove();

            if(curr != null) {
                sb.append(String.valueOf(curr.data) + ":");
                nodeQ.add(curr.left);
                nodeQ.add(curr.right);
            }
            else
                sb.append("#:");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println("========SerializedTreeAsString=========");
        System.out.println(sb.toString());
        return sb.toString();

    }

}
