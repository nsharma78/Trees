/*
 * Create BST from sorted array
 * Create tree in level order from given array
 * Given array {1,2,3,4,5,6,7}
 * ==========Create BST from sorted array and print tree==========
       4
     2   6
   1  3 5  7
   ==========Create tree in level order from given array==========
       1
     2   3
   4  5 6  7
   
   Time O(n), Space O(n)
 */

package com.nitin.algo;

public class TreeUtils {


	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
	
		Node root = sortedArrayToBST(arr, 0, arr.length - 1);
		printBST(root);
		
		root = insertLevelOrder(arr, null, 0);
		printLevelOrder(root);
	}

	public static void printLevelOrder(Node root) {
		System.out.println("==========LevelOrder Tree View==========");
		System.out.println("           " + root.data);
		System.out.println("       " + root.left.data + "       " + root.right.data);
		System.out.println("    " + root.left.left.data + "    " + root.left.right.data + "   " + root.right.left.data + "    " + root.right.right.data);
		System.out.println("  " + root.left.left.left.data + "   " + root.left.left.right.data);
	}

	public static void printBST(Node root) {
		System.out.println("==========BST Tree View==========");
		System.out.println("           " + root.data);
		System.out.println("       " + root.left.data + "       " + root.right.data);
		System.out.println("    " + root.left.left.data + "    " + root.left.right.data + "   " + root.right.left.data + "    " + root.right.right.data);
		System.out.println("          " + root.left.right.right.data + "         " + root.right.right.right.data);
	}

	//sorted array to BST
	public static Node sortedArrayToBST(int[] arr, int start, int end) {
		// Base case
		if(start > end)
			return null;
		
		int mid = (start + end)/2;
		Node node = new Node(arr[mid]);
		
		node.left = sortedArrayToBST(arr, start, mid - 1);
		node.right = sortedArrayToBST(arr, mid + 1, end);
		
		return node;
	}
	
	// create tree level order
	public static Node insertLevelOrder(int[] arr, Node node, int arrPos) {
		
		Node root = null;
		if(arrPos < arr.length) {
			
			root = new Node(arr[arrPos]);
			node = root;
			
			node.left = insertLevelOrder(arr, node.left, 2 * arrPos + 1);
			node.right = insertLevelOrder(arr, node.right, 2 * arrPos + 2);
		}
		
		return root;
	}
	
	// Tree node
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int d){
			data = d;
			left = right = null;
		}
	}

}
