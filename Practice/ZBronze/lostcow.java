import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class lostcow {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("lostcow.in"));
		PrintWriter pw = new PrintWriter(new File("lostcow.out"));
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int count = 0;
		if (x<y) {
			int er = 0;
			int i = 1;
			int pv = 0;
			y = y-x;
			x = 0;
			while(x<y) {
				if (er%2 == 0) x = x+i+pv;
				else x = x-i-pv;
				//System.out.println(x);
				count += pv+i;
				pv = i;
				er++;
				i = i*2;
				//System.out.println(count);
			}//System.out.println(y + " "+ x);
			count += y-x;
		}
		else if (x>y) {
			
			int er = 0;
			int i = 1;
			int pv = 0;
			y = y-x;
			x = 0;
			while(x>y) {
				if (er%2 == 0) x = x+i+pv;
				else x = x-i-pv;
				//System.out.println(x);
				count += pv+i;
				pv = i;
				er++;
				i = i*2;
				//System.out.println(count);
			}
			//System.out.println(y + " "+ x);
			count += x-y;
			//System.out.println(count);
		}
		else count = 0;
		
		pw.println(count);
		pw.close();
	}
	
}
