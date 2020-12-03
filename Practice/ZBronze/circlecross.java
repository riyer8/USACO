import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class circlecross {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("circlecross.in"));
		PrintWriter pw = new PrintWriter(new File("circlecross.out"));
		ArrayList<Integer> enter = new ArrayList<Integer>();
		ArrayList<Integer> exit = new ArrayList<Integer>();
		String s = sc.next();
		for (int i = 65; i<=90;i++) {
			int a = s.indexOf((char) i);
			int b = s.lastIndexOf((char)i);
			if (Math.abs(a-b) != 1) {
				enter.add(a);
				exit.add(b);
			}
		}
		for (int i = 0; i<enter.size()-1; i++) {
			int min = Integer.MAX_VALUE;
			int ind = -1;
			for (int j = i; j<enter.size(); j++) {
				if (enter.get(j)<min) {
					min = enter.get(j);
					ind = j;
				}
			}
			enter.remove(ind);
			enter.add(ind, enter.get(i));
			enter.remove(i);
			enter.add(i, min);
			int q = exit.get(ind);
			exit.remove(ind);
			exit.add(ind,exit.get(i));
			exit.remove(i);
			exit.add(i,q);
		}
		int count = 0;
		for (int i = 0; i<enter.size()-1; i++) {
			for (int j = i+1; j<enter.size(); j++) {
				if ((exit.get(i) < exit.get(j))&&(enter.get(j) < exit.get(i)))count++;
			}
		}
		pw.println(count);
		pw.close();
	}
	
}
