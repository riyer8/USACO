import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class square {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("square.in"));
		PrintWriter pw = new PrintWriter(new File("square.out"));
		
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();
		int x4 = sc.nextInt();
		int y4 = sc.nextInt();
		
		int a = Math.max(x2, x4);
		int b = Math.max(y2, y4);
		int c = Math.min(x1, x3);
		int d = Math.min(y1, y3);
		
		int g = Math.abs(c-a);
		int h = Math.abs(b-d);
		
		int t = Math.max(g, h);
		
		pw.println(t*t);
		
		
		pw.close();
	}
}
