import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class sleepy {
	static int count = 0;
	public static class Node {
		Node left, right;
		int val, smallervalues;
		public Node(int v) { //value of node
			val = v;
		}
		public String toString() {
			return val+"";
		}
	}
	public static int add(Node root, Node add) {
		if (root.val < add.val) { //must go right
			count+=root.smallervalues+1; //counting number of smaller values
			if (root.right == null) {
				root.right = add; //added if empty
				return count;
			}
			return add(root.right,add); // keeps going down till right node is empty
		}
		else {
			root.smallervalues++;
			if (root.left == null) {
				root.left = add;
				return count;
			}
			return add(root.left,add);
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("sleepy.in"));
		PrintWriter pw = new PrintWriter(new File("sleepy.out"));

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i<n; i++) {
			arr[i]  =sc.nextInt();
		} //inputs
		
		int right_index = n-2;
		int min_value = arr[n-1];
		while(arr[right_index]<min_value) { //greatest increasing sequence
			min_value = arr[right_index--];
		}
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(arr[right_index]-1); //everything will be sorted at this point
		
		int start = right_index;
		Node root = new Node(arr[right_index--]);
		
		while(right_index>=0) {
			int num = add(root,new Node(arr[right_index])); //overcounts
			int store = start-right_index + arr[right_index--]-1-num; //less than to be sorted + total less - overcounts
			answer.add(store);
			count = 0; //restart counting			
		}
		pw.println(answer.size());
		for (int i = answer.size()-1; i>=0; i--) {
			if (i == 0) pw.print(answer.get(i));
			else pw.print(answer.get(i) + " ");
		}
		pw.close();
	}
}