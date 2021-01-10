import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

//Binary Indexed Tree: works similar to a binary search
//add elements and maintain sorted order in O(log n) -- instead of O(n)
//accessing elements takes O(log n) -- instead of O(1)


public class BinaryIndexedTree {
	public static class Node {
		Node left, right;
		int val;
		public Node(int v) {
			val = v;
		}
	}
	public static void add(Node root, int add) {
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
		//print nodes out in order
		if (root == null) return; //always have a null check in trees
		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}
	public static void inordernonrec(Node root) {
		//prints nodes out in order without recursion
		if (root == null) return; //always have a null check in trees
		Stack<Node> stack = new Stack<Node>();
		while (root != null || stack.size() > 0) {
			while (root !=  null) { //go as left as possible -- the smallest value
				stack.push(root);
				root = root.left;
			}
			root = stack.pop(); //pops the smallest value
			System.out.print(root.val + " ");
			root = root.right; //goes to the right of node, next smallest
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		Node root = new Node(0); //random value -- this will be overwritten when the first number is inputted
		while(true) {
			System.out.println("Enter a number to add to the tree: ");
			int add = sc.nextInt();
			if (count == 0) root = new Node(add);
			add(root, add);
			System.out.print("Inorder traversal: ");
			inorderTraversal(root);
			System.out.println();
			System.out.print("Non-recursion inorder traversal: ");
			inordernonrec(root);
			System.out.println();
			System.out.println("-------------------------------------");
			count++;
		}
	}
}