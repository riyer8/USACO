import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class teamwork {
	//a dp problem
	static int[] arr, dp;
	static int n,k;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("teamwork.in"));
		PrintWriter pw = new PrintWriter(new File("teamwork.out"));

		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		} //problem inputs
		dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = arr[0]; // initializing dp array
		pw.println(dpmethod(n));
		pw.close();
	}
	public static int dpmethod(int current) {
		if (dp[current]!=Integer.MAX_VALUE)	return dp[current]; //already computed
		int cowseen = 0, maxvalue = 0;
		for (int i = 1; i<=k; i++) {
			if (current<i) break; //out-of-bound case
			cowseen = Math.max(cowseen, arr[current-i]); //max skill level
			maxvalue = Math.max(maxvalue, i*cowseen+dpmethod(current-i)); //max group skill level
		}
		dp[current] = maxvalue;
		return dp[current];
	}
}