import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class poetry {
	static int mod = 1000000007;
	static long[] minidp; //the smaller dp problem inside of the main dp array
	static long[] letter_dp; //overarching dp problem. ways to assign A, B, C, etc.
	static word[] arr;
	static class word {
		long s,c;
	}
	static long minidp_function(int syllables) {
		if (syllables<0) return 0;
		if (minidp[syllables]!=Long.MAX_VALUE) return minidp[syllables]%mod;
		long store = 0;
		for (int i = 0 ; i<arr.length; i++) {
			store += minidp_function(syllables-(int)arr[i].s);
			store = store%mod;
		}
		minidp[syllables] = store%mod;
		return minidp[syllables];
	}
	// k^(2n) = (k^2)^n
	//k^(2n+1) = k^2n*k
	//solves in log time
	static long expBySq(long base, long exp) {
		base = base%mod;
		if (exp == 0) return 1;
		if (exp == 1) return base%mod; //base cases
		if (exp%2 == 0) return expBySq((base*base)%mod, exp/2)%mod; //even exp
		return (base*(expBySq((base*base)%mod, exp/2))%mod)%mod; //odd exp
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("poetry.in"));
		PrintWriter pw = new PrintWriter(new File("poetry.out"));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		HashMap<Long, ArrayList<Long>> rclass = new HashMap<Long, ArrayList<Long>>(); //rhyme classes mapped to syllables 
		HashMap<Character, Long> groups = new HashMap<Character, Long>(); //characters that are the same
		arr = new word[n];
		for (int i  = 0; i<n; i++) {
			long si = sc.nextLong();
			long ci = sc.nextLong();
			arr[i] = new word();
			arr[i].s = si;
			arr[i].c = ci;
			if (!rclass.containsKey(arr[i].c)) rclass.put(arr[i].c, new ArrayList<Long>());
			rclass.get(arr[i].c).add(arr[i].s);
		} //inputs
		for (int i = 0; i<m;i++) {
			String r = sc.next();
			if (!groups.containsKey(r.charAt(0))) groups.put(r.charAt(0),(long)0);
			groups.put(r.charAt(0), groups.get(r.charAt(0))+1);
		}
		minidp = new long[k];
		Arrays.fill(minidp, Long.MAX_VALUE);
		minidp[0] = 1; //if we can get to 0, we have found a way to add to n
		letter_dp = new long[26];
		for (int i = 0; i<26; i++) { //looping through all letters
			if (groups.containsKey((char)(i+'A'))) { //making sure they are contained in the problem/map
				Iterator it = rclass.entrySet().iterator(); //iterate through the hashmap
				while(it.hasNext()) {
					Map.Entry pair = (Map.Entry)it.next(); //find the key and value of the map
					long count = 0; 
					for (long sylab: (ArrayList<Long>)pair.getValue()) { //pair.getValue() stores the arraylist rhyme class to the syllables
						count+=minidp_function(k-(int)sylab)%mod;
						count = count%mod;
					}
					// can't do 'letter_dp[i] = (long)Math.pow(count, groups.get((char)(i+'A')))%mod' because it could stack overflow
					letter_dp[i] += expBySq(count, groups.get((char)(i+'A')));
				}
				if (i != 0) letter_dp[i] = (letter_dp[i]%mod*(letter_dp[i-1])%mod)%mod;
			}
			else { //not in map
				if (i != 0) letter_dp[i] = letter_dp[i-1]%mod;
				else letter_dp[0] = 1;
			}
		}
		pw.print(letter_dp[25]%mod);
		pw.close();
	}
	
}