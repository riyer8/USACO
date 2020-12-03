import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class billboard {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("billboard.in"));
		PrintWriter pw = new PrintWriter(new File("billboard.out"));
		
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();
		int x4 = sc.nextInt();
		int y4 = sc.nextInt();
		
		//intersection points
		int a = Math.max(x1,x3);
		int b = Math.max(y1,y3);
		int c = Math.min(x2,x4);
		int d = Math.min(y2,y4);
		int area = 0;
		System.out.println(a+" " + b + " " + c + " " + d);
		if ((a == x1 && b == y1) || (c == x2 && d == y2)) {
			area = (c-a)*(d-b);
			System.out.println(area);
		}
		int tot = (x2-x1)*(y2-y1) - area;
		System.out.println(tot);
		pw.println(tot);
		pw.close();
	}
	
}