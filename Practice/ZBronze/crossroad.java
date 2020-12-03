import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class crossroad {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("crossroad.in"));
		PrintWriter pw = new PrintWriter(new File("crossroad.out"));
		int n = sc.nextInt();
		HashMap<Integer,Integer> arr = new HashMap<Integer,Integer>();
		int count = 0;
		for (int i = 0; i<n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (arr.containsKey(a)) {
				if (arr.get(a) != b) {
					count++;
					arr.put(a, b);
				}
			}
			else {
				arr.put(a, b);
			}
		}
		pw.println(count);
		
		
		
		pw.close();
	}
	
}
