/*
 * Given an N-ary tree where every node has at-most N children. How to serialize and deserialze it?
 * Serialization is to store tree in a file so that it can be later restored. The structure of tree must be maintained.
 * Deserialization is reading tree back from file.
 *
 *In an N-ary tree, there are no designated left and right children. An N-ary tree is represented by storing an array or list of child pointers with every node.
 *The idea is to store an ‘end of children’ marker with every node.
 */

package main.java;

import java.util.Stack;

public class NaryTreeSerializeDeserialize {
    private static final int SIZE = 5;
    private static final char MARKER = ')';
    public static Node root;

    static class Node {
        char key;
        Node[] child;

        public Node(char c) {
            this.key = c;
            child = new Node[SIZE];
        }
    }

    private static Node createDummyTree() {
        Node root = new Node('A');
        root.child[0] = new Node('B');
        root.child[1] = new Node('C');
        root.child[2] = new Node('D');
        root.child[0].child[0] = new Node('E');
        root.child[0].child[1] = new Node('F');
        root.child[2].child[0] = new Node('G');
        root.child[2].child[1] = new Node('H');
        root.child[2].child[2] = new Node('I');
        root.child[2].child[3] = new Node('J');
        root.child[0].child[1].child[0] = new Node('K');
        return root;
    }

    private static void traverse(Node root) {
        if (root == null)
            return;
        else {
            System.out.print(root.key + " ");
            Node[] children = root.child;
            for (int i = 0; i < children.length; i++)
                traverse(children[i]);
        }
    }

    private static void serialize(StringBuilder sb, Node root) {
        if (root == null)
            return;

        sb.append(root.key);
        Node[] children = root.child;
        for (int i = 0; i < children.length; i++)
            serialize(sb, children[i]);
        sb.append(MARKER);
    }

    private static Node deserialize(String str) {
        if (str == null || str.isEmpty())
            return null;

        int i = 0;
        Node newRoot = new Node(str.charAt(i));
        Stack<Node> stk = new Stack<>();
        stk.push(newRoot);
        int j = 0;

        for (i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ')')
                stk.push(new Node(c));
            else {
                Node n1 = stk.pop();
                if (n1 == newRoot)
                    return n1;
                Node n2 = stk.pop();
                for (int k = 0; k < SIZE; k++)
                    if (n2.child[k] == null) {
                        j = k;
                        break;
                    }
                n2.child[j] = n1;
                stk.push(n2);
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        Node root = createDummyTree();
        System.out.println("=====OriginalTree=====");
        traverse(root);

        StringBuilder sb = new StringBuilder();
        serialize(sb, root);
        System.out.println("\n=====SerializedString=====");
        System.out.println(sb.toString());

        Node newRoot = deserialize(sb.toString());
        System.out.println("=====DeserializedTree=====");

        traverse(newRoot);
    }
}
