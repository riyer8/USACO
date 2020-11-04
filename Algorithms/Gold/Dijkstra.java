import java.io.*;
import java.util.*;
import java.awt.*;
import java.math.*;

public class Dijkstra {
	public class Pair implements Comparable<Pair> {
		int a,b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int compareTo(Pair p) {
			return Integer.compare(b, p.b);
		}
		
	}
	public void run() throws Exception {
		Scanner file = new Scanner(new File("dijkstra.in"));
		int n = file.nextInt();
		int m = file.nextInt();
		LinkedList<Pair>[] adj = new LinkedList[n];
		for (int i = 0; i<n; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int i =0; i< m; i++) {
			int a = file.nextInt()-1, b = file.nextInt()-1, c = file.nextInt();
			adj[a].add(new Pair(b,c));
			adj[b].add(new Pair(a,c));
		}
		int[] best = new int[n];
		Arrays.fill(best, Integer.MAX_VALUE);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0,0));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			int i = p.a, dist = p.b;
			if (best[i]<=dist) continue;
			best[i] = dist;
			for (Pair nx: adj[i]) {
				pq.add(new Pair(nx.a, dist+nx.b));
			}
			for (int b: best) System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Dijkstra().run();
	}
}
