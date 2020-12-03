import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class cowsignal {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("cowsignal.in"));
		PrintWriter pw = new PrintWriter(new File("cowsignal.out"));
		
		int m =sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		char[][] ori = new char[m][n];
		char[][] fin = new char[m*k][n*k];
		for (int i = 0; i<m; i++) {
			char[] arr = sc.next().toCharArray();
			ori[i] = arr;
		}
		for (int i = 0; i<m*k; i++) {
			for (int j = 0;j<n*k; j++) {
				fin[i][j] = ori[i/k][j/k];
				pw.print(fin[i][j]);
			}
			pw.println();
		}
		
		
		/*
		int M = sc.nextInt();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		char[][] matrix = new char[M][N];
		for(int i = 0; i < M; i++) {
			matrix[i] = sc.next().toCharArray();
		}
		
		char[][] answer = new char[K*M][K*N];
		
		for(int i = 0; i < M; i++) {
			String s = "";
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < K; k++) {
					
					s = s + matrix[i][j];
				}
			}
			for(int j = 0; j < K; j++) {
				pw.println(s);
			}
		}
		
		
		*/
		pw.close();
	}
	
}
