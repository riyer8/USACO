import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class billboard2{ //bottom1          bottom2          top1           top2
	public static int cov(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		int x5 = Math.max(x1, x2);
		int y5 = Math.max(y1, y2);
		int x6 = Math.min(x3, x4);
		int y6 = Math.min(y3, y4);
		if (x6<x5 || y6<y5) {
			return 0;
		}
		return (x6-x5) * (y6-y5);
		
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("billboard2.in"));
		PrintWriter pw = new PrintWriter(new File("billboard2.out"));
		//3 billboards (NOT 2018 Jan)
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();
		int x4 = sc.nextInt();
		int y4 = sc.nextInt();
		int x5 = sc.nextInt();
		int y5 = sc.nextInt();
		int x6 = sc.nextInt();
		int y6 = sc.nextInt();
		
		int tot = (x2-x1)*(y2-y1)+(x4-x3)*(y4-y3);// System.out.println(tot);
		int cov1 = cov(x1,y1, x5, y5, x2, y2, x6,y6);
		int cov2 = cov(x3,y3, x5, y5, x4, y4, x6,y6);
		pw.println(tot-cov1-cov2);
		
		pw.close();
	}
	
}