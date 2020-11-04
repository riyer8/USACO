import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class planting {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("planting.in"));
		PrintWriter pw = new PrintWriter(new File("planting.out"));
		int n = sc.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[n];
		for (int i =0 ; i<n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i<n-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a-1].add(b-1);
			arr[b-1].add(a-1);
		}
		int max = 0;
		for (int i =0 ; i<n;i++) {
			max = Math.max(max,1+arr[i].size());
		}
		System.out.println(max);
		pw.println(max);
		
		
		
		pw.close();
	}
	
}