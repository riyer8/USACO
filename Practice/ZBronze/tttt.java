import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class tttt {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("tttt.in"));
		PrintWriter pw = new PrintWriter(new File("tttt.out"));
		
		char[][] ttt = {sc.next().toCharArray(),sc.next().toCharArray(),sc.next().toCharArray()};

		int w1 = 0, w2 = 0;
		HashSet<String> hs1 = new HashSet<String>(), hs2 = new HashSet<String>();
		
		for (int i = 0; i<3; i++) {
			if ((ttt[i][0] == ttt[i][1]) &&(ttt[i][0] == ttt[i][2])) hs1.add(ttt[i][0]+"");
			else if ((ttt[i][0] == ttt[i][1]) ||(ttt[i][0] == ttt[i][2])||((ttt[i][0] == ttt[i][1]))) {
				TreeSet<Character> ts = new TreeSet<Character>();
				ts.add(ttt[i][0]);
				ts.add(ttt[i][1]);
				ts.add(ttt[i][2]);
				hs2.add(ts.toString());
			}
			if ((ttt[0][i] == ttt[1][i]) &&(ttt[0][i] == ttt[2][i])) hs1.add(ttt[0][i]+"");
			else if ((ttt[0][i] == ttt[1][i]) ||(ttt[0][i] == ttt[2][i])||((ttt[0][i] == ttt[1][i]))) {
				TreeSet<Character> ts = new TreeSet<Character>();
				ts.add(ttt[0][i]);
				ts.add(ttt[1][i]);
				ts.add(ttt[2][i]);
				hs2.add(ts.toString());
			}
		}
		if ((ttt[0][0] == ttt[1][1]) &&(ttt[0][0] == ttt[2][2]))hs1.add(ttt[0][0]+"");
		else if ((ttt[0][0] == ttt[1][1]) ||(ttt[0][0] == ttt[2][2])||((ttt[0][0] == ttt[1][1]))) {
			TreeSet<Character> ts = new TreeSet<Character>();
			ts.add(ttt[0][0]);
			ts.add(ttt[1][1]);
			ts.add(ttt[2][2]);
			hs2.add(ts.toString());
		}
		if ((ttt[0][2] == ttt[1][1]) &&(ttt[0][2] == ttt[2][0])) hs1.add(ttt[0][2]+"");
		else if ((ttt[0][2] == ttt[1][1]) ||(ttt[0][2] == ttt[2][0])||((ttt[0][2] == ttt[1][1]))) {
			TreeSet<Character> ts = new TreeSet<Character>();
			ts.add(ttt[0][2]);
			ts.add(ttt[1][1]);
			ts.add(ttt[2][0]);
			hs2.add(ts.toString());
		}
		//problem possibly bc if same cows can't be claim different victories. ex: BCB BCB CBC. BBC col1 is the sam as BBC col3
		pw.println(hs1.size());
		//System.out.println(hs2);
		pw.println(hs2.size());
		pw.close();
	}
	
}
