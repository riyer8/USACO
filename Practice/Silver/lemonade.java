import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class lemonade {
	// greedy problem
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("lemonade.in"));
		PrintWriter pw = new PrintWriter(new File("lemonade.out"));
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int inline = 0;
		for (int i =n-1 ; i>=0; i--) {
			if (inline>arr[i]) break;
			inline++;
		}
		pw.println(inline);
		
		pw.close();
	}
	
}