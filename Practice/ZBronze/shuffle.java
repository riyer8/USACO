import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class shuffle {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("shuffle.in"));
		PrintWriter pw = new PrintWriter(new File("shuffle.out"));
		
		int n = sc.nextInt();
		int[] shuffle = new int[n];
		int[] names = new int[n];
		for (int i = 0; i<n; i++) {
			shuffle[i] = sc.nextInt();
		}
		for (int i = 0; i<n; i++) {
			names[i] = sc.nextInt();
		}
		
		for (int i = 0; i<3; i++) {
			int[] names2 = new int[n];
			for (int j = 0; j<n; j++) {
				names2[j] = names[shuffle[j]-1];
			}
			System.out.println(Arrays.toString(names2));
			for (int  j =0; j<n; j++) {
				names[j] = names2[j];
			}
		}
		for (int i = 0; i<n; i++) {
			System.out.println(names[i]);
			pw.println(names[i]);
		}
		
		
		/*
		int n =sc.nextInt();
		
		int[] shuffle = new int[n];
		
		int[] end = new int[n];
		
		for (int i = 0; i<n; i++) {
			shuffle[i] = sc.nextInt();
		}
		
		for (int i = 0; i<n; i++) {
			end[i] = sc.nextInt();
		}
		
		int[] temp = new int[n];
		
		for (int i = 0; i<n; i++) {
			temp[i] = i+1;
		}
		
		for (int asdf = 0; asdf<3; asdf++) {
			
			int[] temp2 = new int[n];
			
			for (int i = 0; i<n; i++) {
				
				int h = shuffle[i] -1;
				
				temp2[h] = temp[i];
				
			}
			
			temp = temp2; //Check this
			
		}
		
		int[] total = new int[n];
		
		for (int i = 0; i<n; i++) {
			
			int u = temp[i] -1;
			
			total[u] = end[i];
			
			
			
		}
		
		for (int i = 0; i<n; i++) {
			pw.println(total[i]);
		}
		*/
		
		pw.close();
	}
	
}
