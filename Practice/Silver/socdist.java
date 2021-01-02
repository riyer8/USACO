import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class socdist {
	// binary search for the answer problem
	static int n, m;
	static ArrayList<Pair> arr;
	public static boolean test(long a) {
		long position = Long.MIN_VALUE;
		int count = 0;
		for (int i = 0; i<m; i++) {
			if (Math.max(arr.get(i).start, position+a) <= arr.get(i).end) {
				position = Math.max(arr.get(i).start, position+a);
				if (count++ == n) return true;
			}
			while (position+a <= arr.get(i).end) {
				position+=a;
				if (count++ == n) return true;
			}
		}
		if (count>=n) return true;
		return false;
	}
	public static class Pair implements Comparable<Pair>{
		long start, end;
		public Pair(long a, long b) {
			start = a;
			end = b;
		}
		public int compareTo(Pair a) {
			if (start == a.start) return (int)Long.compare(end, a.end);
			return (int)Long.compare(start, a.start);
		}
		public String toString() {
			return start + " " +  end;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("socdist.in"));
		PrintWriter pw = new PrintWriter(new File("socdist.out"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new ArrayList<Pair>();
		for (int i = 0; i<m; i++) {
			arr.add(new Pair(sc.nextLong(), sc.nextLong()));
		}
		Collections.sort(arr);
		
		long low = 0;
		long high = Long.MAX_VALUE;
		long ans = -1;
		while(high>=low) {
			long mid = (low+high)/2;
			if (test(mid)) {
				ans = Math.max(ans, mid);
				low = mid+1;
			}
			else high = mid-1;
		}
		pw.println(ans);
					
		pw.close();
	}
	
}