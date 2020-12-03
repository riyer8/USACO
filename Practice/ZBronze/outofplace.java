import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class outofplace {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("outofplace.in"));
		PrintWriter pw = new PrintWriter(new File("outofplace.out"));
		
		int times = sc.nextInt();
		int[] lu = new int[times];
		for (int i = 0; i<times; i++) {
			lu[i] = sc.nextInt();
		}
		int in1 = -1, in2 = -1;
		for (int i = 1; i<times; i++) {
			if (lu[i-1]>lu[i]) {
				in1 = i-1;
				in2 = i;
				break;
			}
		}
		boolean ok = false;
		System.out.println(lu[in1] + " " + lu[in2]);
		if (in1-1 >=0 && lu[in1-1] > lu[in2]) {
			ok = true;
		}
		int count = 0;
		System.out.println(ok);
		if (ok) {
			TreeSet<Integer> arr = new TreeSet<Integer>();
			for (int i = 0; i<in2; i++) {
				arr.add(lu[i]);
			}
			//int count = 0;
			for (int i: arr) {
				if (i<=lu[in2]) count++;
			}
			count = arr.size() - count;
		}
		else {
			TreeSet<Integer> arr = new TreeSet<Integer>();
			
			for (int i = in2; i<lu.length; i++) {
				arr.add(lu[i]);
			}
			System.out.println(arr);
			//int count = 0;
			for (int i: arr) {
				if (i>=lu[in1]) count++;
			}
			count = arr.size() - count;
		}
		System.out.println(count);
		pw.println(count);
		pw.close();
	}
	
}