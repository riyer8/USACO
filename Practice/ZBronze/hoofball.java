import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class hoofball {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("hoofball.in"));
		PrintWriter pw = new PrintWriter(new File("hoofball.out"));
		
		int num = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Boolean> bool = new ArrayList<Boolean>();
		for (int i =0 ; i<num; i++) {
			arr.add(sc.nextInt());
			bool.add(false);
		}
		Collections.sort(arr);
		ArrayList<Integer> diff = new ArrayList<Integer>();
		for (int i = 0; i<num-1; i++) {
			diff.add(Math.abs(arr.get(i+1) -arr.get(i)));
		}
		
		pw.close();
	}
	
}
