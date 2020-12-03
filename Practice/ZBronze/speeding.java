import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class speeding {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("speeding.in"));
		PrintWriter pw = new PrintWriter(new File("speeding.out"));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<Integer> limit = new ArrayList<Integer>();
		ArrayList<Integer> drive = new ArrayList<Integer>();
		for (int i = 0; i<2*n; i++) {
			limit.add(sc.nextInt());
		}
		
		for (int i = 0; i<2*m; i++) {
			drive.add(sc.nextInt());
		}
		
		int[] lim = new int[100];
		int[] driver = new int[100];
		int[] diff = new int[100];
		
		int small = 0;
		for (int i = 0; i<2*n; i=i+2) {
			
			int q = limit.get(i)+small;
			
			for (int j = small; j<q; j++) {
				lim[j] = limit.get(i+1);
			}
			
			small = q;
		}
		
		
		int little = 0;
		for (int i = 0; i<2*m; i=i+2) {
					
			int q = drive.get(i)+little;
			for (int j = little; j<q; j++) {
					driver[j] = drive.get(i+1);			
			}
					
			little = q;
					
		}
		
		for (int i = 0; i<100; i++) {
			diff[i] = driver[i] - lim[i];
		}
		
		ArrayList<Integer> diff1 = new ArrayList<Integer>();
		
		for (int i = 0; i<100; i++) {
			diff1.add(diff[i]);
		}
		
		Collections.sort(diff1);
		
		if (diff1.get(diff1.size()-1)<0) {
			pw.println(0);
		}
		else {
			pw.println(diff1.get(diff1.size()-1));
		}
		
		
		
		
		pw.close();
	}
	
}
