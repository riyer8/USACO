import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class milkorder {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("milkorder.in"));
		PrintWriter pw = new PrintWriter(new File("milkorder.out"));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int de = sc.nextInt();
		ArrayList<Integer> order = new ArrayList<Integer>(), cows = new ArrayList<Integer>(), cows1 = new ArrayList<Integer>();
		
		for (int i =0; i<n; i++ ) {
			cows.add(0);
		}
		for (int i = 0; i<m; i++) {
			order.add(sc.nextInt());
		}
		for (int i = 0; i<de; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			cows.set(b-1, a);
		}
		if (cows.indexOf(1) != -1) {
			System.out.println(cows.indexOf(1)+1);
			pw.println(cows.indexOf(1)+1);
			pw.close();
			return;
		}
		
		for (int i = cows.size()-1; i>=0; i--) {
			//if (cows.ge)
			for (int j = order.size()-1; j>=0; j--) {
				int a = order.get(i);
			}
		}		
		/*
		//all inputs above
		System.out.println(cows);
		outer:
		for (int i = 0; i<n; i++) { // putting 1 in the position closest to the beginning
			cows1 = new ArrayList<Integer>();
			for (int j = 0; j<n; j++) {
				cows1.add(cows.get(j));
			}
			if (cows1.get(i) != 0) continue;
			cows1.set(i,1);
			for (int j = 0; j<m; j++) {
				int a = order.get(j);
				if (cows1.indexOf(a) == -1) {
					cows1.set(cows1.indexOf(0), a);
				}
			}
			System.out.println(cows1);
			ArrayList<Integer> ind = new ArrayList<Integer>();
			for (int j = 0; j<m; j++) {
				ind.add(cows1.indexOf(order.get(j)));
			}
			System.out.println(ind);
			for (int j = 0; j<m-1; j++) {
				if (ind.get(j+1) - ind.get(j)<0) continue outer;
			}
			
			break;
		}
		System.out.println(cows1.indexOf(1)+1);
		pw.println(cows1.indexOf(1)+1);
		*/
		
		pw.close();
	}
	
}
