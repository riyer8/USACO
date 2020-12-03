import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class paint {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("paint.in"));
		PrintWriter pw = new PrintWriter(new File("paint.out"));
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int g = Math.min(a, c);
		int h = Math.max(b, d);
		
		int extra= 0;
		if (b<c) {
			extra = c-b;
		}
		else if (d<a) {
			extra = a-d;
		}
		pw.println(h-g-extra);
		
		
		
		pw.close();
	}
	
}
