import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class cowqueue {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("cowqueue.in"));
		PrintWriter pw = new PrintWriter(new File("cowqueue.out"));
		
		long times = sc.nextLong();
		ArrayList<Long> enter = new ArrayList<Long>();
		ArrayList<Long> exit = new ArrayList<Long>();
		ArrayList<Long> total = new ArrayList<Long>();
		
		for (long i = 0; i<times; i++) {
			long a = sc.nextInt();
			long b = sc.nextInt();
			enter.add(a);
			exit.add(b);
		}
		//going to be our answer for the amount of time
		long count = enter.get(0)+exit.get(0);
		
		//sorting all the starting times in order
		for (int i = 0; i<enter.size()-1; i++) {
			long min = Long.MAX_VALUE;
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
			long q = exit.get(ind);
			exit.remove(ind);
			exit.add(ind,exit.get(i));
			exit.remove(i);
			exit.add(i,q);
		}		
		//finding the total between the start times and q times
		for (int i = 0; i<enter.size(); i++) {
			total.add(enter.get(i)+exit.get(i));
		}
		//cases for the timings
		for (int i = 1; i<enter.size(); i++ ) {
			if (count<enter.get(i)) count = total.get(i);
			else count+= exit.get(i);
		}
		pw.println(count);
		pw.close();
	}
	
}
