import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class teleport {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("teleport.in"));
		PrintWriter pw = new PrintWriter(new File("teleport.out"));
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int q = Math.abs(a-b);
		int w = Math.abs(a-x) + Math.abs(b-y);
		int e = Math.abs(a-y) + Math.abs(b-x);
		
		int r = Math.min(q, w);
		int t = Math.min(e, r);
		
		pw.println(t);
		
		
		pw.close();
	}
	
}
