import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class cowtip {
	public static int n;
	public static void flip(int[][] q, int a, int b, int w, int e) {
		for (int i = w; i>=a; i--) {
			for (int j = e; j<=b; j++) {
				q[i][j] = 1-q[i][j];
			}
		}
	}
	public static String low(int[][] q, int a, int b) {
		for (int i = 0; i<b; i++) {
			for (int j = n-1; j>=a; j--) {
				if (q[j][i] == 1) {
					return j + " " + i;
				}
			}
		}
		return "";
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("cowtip.in"));
		PrintWriter pw = new PrintWriter(new File("cowtip.out"));
		
		n = sc.nextInt();
		int[][] a = new int[n][n];
		int[][] ab = new int[n][n];
		for (int i =0 ; i<n; i++) {
			String s = sc.next();
			for (int j =0; j<n; j++) {
				a[i][j] = Integer.parseInt(s.charAt(j)+"");
				ab[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}
		int count1 = 0;
		outer:
		for (int i = 0; i<n; i++) {
			for (int j = n-1; j>=0; j--) {
				if (a[i][j] == 1) {
					System.out.println(Arrays.deepToString(a));
					String s = low(a,i,j);
					int in = s.indexOf(" ");
					if (in == -1) {a[i][j] = 0; count1++;}
					else {
					int w = Integer.parseInt(s.substring(0, in));
					int e = Integer.parseInt(s.substring(in+1));
					flip(a,i,j,w,e);
					count1++;
					}
				}
			}
		}
		System.out.println(count1);
		//bc this assumes to take the top left and lowest right, but sometimes not the best choice
		//for example: 3; 001 000 100 will switch the entire thing to 110 111 011, creating more work than just switching them individually
		//can try to count the # of 0 and 1 and find if it is wise to change 
		//but what if 101 010 101, that would also be a lot more work than just switching individually
		
		
		pw.close();
	}
	
}