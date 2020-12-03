import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class lifeguards {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new File("lifeguards.out"));
		
		int times = sc.nextInt();
		ArrayList<Integer> s = new ArrayList<Integer>(), e = new ArrayList<Integer>();
		for(int i = 0; i<times; i++) {
			s.add(sc.nextInt());
			e.add(sc.nextInt());
		}
		int min = 10000;
		int max = -4;
		for (int i =0 ; i<times; i++) {
			if (s.get(i)<min) min = s.get(i);
			if (e.get(i)>max) max = e.get(i);
		}
		max = max-min;
		for (int i = 0; i<times; i++) {
			s.set(i, s.get(i)-min);
			e.set(i, e.get(i)-min);
		}
		min = 0;
		int[] arr = new int[max];
		for (int i = 0; i<times; i++) {
			for (int j = s.get(i); j<e.get(i); j++) {
				arr[j] +=1;
			}
		}
		//System.out.println(Arrays.toString(arr));
		int hours = 0;
		for (int i = 0; i<times; i++) {
			int count = 0;
			for (int j = s.get(i); j<e.get(i); j++) {
				arr[j]-=1;
			}
			//System.out.println(Arrays.toString(arr));
			for (int j = 0; j<arr.length; j++) {
				if (arr[j] != 0) count++;
			}
			//System.out.println(count);
			if (hours<count) hours = count;
			for (int j = s.get(i); j<e.get(i); j++) {
				arr[j] +=1;
			}
			//System.out.println(Arrays.toString(arr));
		}
		pw.println(hours);
		pw.close();
	}
	
}