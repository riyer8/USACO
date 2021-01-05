import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

//Binary Indexed Tree: works similar to a binary search
//add elements and maintain sorted order in O(log n) -- instead of O(n)
//accessing elements takes O(log n) -- instead of O(1)


public class BinaryTree {
	public static class Node {
		Node left, right;
		int val;
		public Node(int v) {
			val = v;
		}
	}
	public static void add (Node root, int add) {
		//if the add is less than the root, it goes to the left
		//if add is greater, then go to the right
		if (root.val < add) {
			if (root.right == null) { //no other trees to its left, add it there
				root.right = new Node(add);
				return;
			}
			add(root.right,add); //then recur it with the beginning node at its left, since that is a tree itself
		}
		else if (root.val > add) {
			if (root.left == null) { //same idea as above
				root.left = new Node(add);
				return;
			}
			add(root.left,add);
		}
	}
	public static void inorderTraversal(Node root) {
		//trying to print it out in order
		if (root == null) { //always have a null check in trees
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Node root = new Node(10); //the beginning node is 10
		while(true) {
			System.out.println("Enter a number to add to the tree: ");
			int add = sc.nextInt();
			add(root, add);
			inorderTraversal(root);
			System.out.println();
		}
	}
}
