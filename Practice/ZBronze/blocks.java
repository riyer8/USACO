import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class blocks {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("blocks.in"));
		PrintWriter pw = new PrintWriter(new File("blocks.out"));
		//my solution
		int n = sc.nextInt();
		String[] arr1 = new String[n];
		String[] arr2 = new String[n];
		
		for (int i =0 ; i<n; i++) {
			arr1[i] = sc.next();
			arr2[i] = sc.next();
		}
		int[][] ans = new int[n][52];
		int[][] ans2 = new int[n][26];
		int[] ans3 = new int[26];
		for (int i = 0; i<n; i++ ) {
			String q = arr1[i];
			String w = arr2[i];
			for (int j = 0; j<q.length(); j++) {
				int a = q.charAt(j);
				ans[i][a-97] +=1;
			}
			for (int j = 0; j<w.length(); j++) {
				int a = w.charAt(j);
				ans[i][a-97+26] +=1;
			}
		}
		System.out.println(Arrays.deepToString(ans));
		for (int i =0 ; i<n; i++) {
			for (int j = 0; j<26; j++) {
				ans2[i][j] = Math.max(ans[i][j], ans[i][j+26]);
			}
		}
		for (int i = 0; i<26; i++) {
			int max = 0;
			for (int j = 0; j<n; j++) {
				max += ans2[j][i];
			}
			ans3[i] = max;
		}
		for (int i = 0; i<26; i++) {
			pw.println(ans3[i]);
		}
		
		/*
		int N = sc.nextInt();
		String[] first_side = new String[N];
		String[] second_side = new String[N];
		
		for(int i = 0; i < 2 * N; i++) {
			if(i % 2 == 0) first_side[i / 2] = sc.next();
			else second_side[i / 2] = sc.next();
		}
		
		for(char i = 'a'; i <= 'z'; i++) {
			int count_let = 0;
			
			for(int j = 0; j < N; j++) {
				
				String a = first_side[j];
				String b = second_side[j];
				
				int count1 = 0, count2 = 0;
				for(int k = 0; k < a.length(); k++) {
					if(a.charAt(k) == i) count1++;
				}
				for(int k = 0; k < b.length(); k++) {
					if(b.charAt(k) == i) count2++;
				}
				
				int big = Math.max(count1, count2);
				count_let += big;
			}
			pw.println(count_let);
		}
		*/
		
		pw.close();
	}
	
}
