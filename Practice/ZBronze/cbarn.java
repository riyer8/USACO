import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class cbarn {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("cbarn.in"));
		PrintWriter pw = new PrintWriter(new File("cbarn.out"));
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		long min = Integer.MAX_VALUE;
		for (int i = 0; i<n; i++) {
			long p = 0;
			for (int j = 0; j<n; j++) {
				int diff = i-j;
				if (diff>0) diff = -1*(diff) + n;
				p += Math.abs(diff)*arr[j];
				System.out.println(p);
			}
			System.out.println("----------------------------------------");
			if (p<min) {
					min = p;
			}
		}
		System.out.println(min);
		pw.println(min);
		
		
		
		
		
		pw.close();
	}
	
}