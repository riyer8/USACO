import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class notlast {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("notlast.in"));
		PrintWriter pw = new PrintWriter(new File("notlast.out"));
		
		int n = sc.nextInt();
		
		String[] name = new String[n];
		int[] num = new int[n];
		
		for (int i = 0; i<n; i++) {
			name[i] = sc.next();
			num[i] = sc.nextInt();
		}
		
		String[] name1 = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
		int[] nums = new int[7];
		
		for (int i = 0; i<n; i++) {
			String q = name[i];
			if (q.equals("Bessie")) {
				nums[0] += num[i];
			}
			else if (q.equals("Elsie")) {
				nums[1] += num[i];
			}
			else if (q.equals("Daisy")) {
				nums[2] += num[i];
			}
			else if (q.equals("Gertie")) {
				nums[3] += num[i];
			}
			else if (q.equals("Annabelle")) {
				nums[4] += num[i];
			}
			else if (q.equals("Maggie")) {
				nums[5] += num[i];
			}
			else if (q.equals("Henrietta")) {
				nums[6] += num[i];
			}
		}
		int[] total = new int[7];
		for (int i = 0; i<7; i++) {
			total[i] = nums[i];
		}
		Arrays.sort(nums);
		
		int w = nums[0];
		int index= 0;
		int count1 = 0;
		for (int i = 0; i<7; i++) {
			if (nums[i] >w) {
				index = i;
				count1++;
				break;
				
			}
			
		}
		if (count1 == 0) {
			pw.println("Tie");
		}
		else {
		int e = nums[index];
		int count = 0;
		for (int i = 0; i<7; i++) {
			if (nums[i] == e) {
				count++;
			}
		}
		
		if (count >1 || count == 0) {
			pw.println("Tie");
		}
		
		else {
			for (int i = 0; i<7; i++) {
				if (total[i] == e) {
					pw.println(name1[i]);
					break;
				}
			}
		}
		
		}
		pw.close();
	}
	
}
