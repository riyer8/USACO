import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class div7 {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("div7.in"));
		PrintWriter pw = new PrintWriter(new File("div7.out"));
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i<n; i++) {
			arr[i] = sc.nextInt()%7;
		}
		int[] small = new int[7];
		int[] large = new int[7];
		Arrays.fill(small, -1);
		for (int i = 0; i<n; i++) {
			if (i>0) arr[i] = (arr[i]+arr[i-1])%7;
			if (small[arr[i]] == -1) small[arr[i]] = i;
			large[arr[i]] = i;
		}
		
		int ans = 0;
		for (int i  =0; i<7;i++) {
			if (small[i] == -1) continue;
			ans = Math.max(large[i]-small[i], ans);
		}
		pw.println(ans);
		
		pw.close();
	}
	
}