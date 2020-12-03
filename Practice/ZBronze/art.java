import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class art {
	static int[][] arr;
	public static boolean finder(int a) {
		int xmax = 0;
		int ymax = 0;
		int xmin = Integer.MAX_VALUE;
		int ymin = Integer.MAX_VALUE;
		for (int i =0 ; i<arr.length; i++) {
			for (int j = 0; j<arr[i].length; j++) {
				if (arr[i][j] == a) {
					if (xmax < i) xmax = i;
					if (ymax < j) ymax = j;
					if (xmin > i) xmin = i;
					if (ymin > j) ymin = j;
				}
			}
		}
		System.out.println(xmax + " " + ymax + " " + xmin + " " + ymin);
		for (int i =xmin; i<=xmax; i++) {
			for (int j = ymin; j<=ymax; j++) {
				if (arr[i][j] != a) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("art.in"));
		PrintWriter pw = new PrintWriter(new File("art.out"));
		
		int n = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i<n; i++) {
			char[] cha = sc.next().toCharArray();
			for (int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(cha[j]+"");
			}
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				int a = arr[i][j];
				if (a != 0 && finder(a)) set.add(a);
			}
		}
		System.out.println(set);
		pw.println(set.size());
		
		
		
		
		pw.close();
	}
	
}
