//Log(n) for updates and queries
public class SegTreeNode {
	static class SegTree {
		int leftmost, rightmost;
		SegTree lChild, rChild;
		long sum ;
		public SegTree(int leftmost, int rightmost, long[] a) {
			this.leftmost = leftmost;
			this.rightmost = rightmost;
			
			if (leftmost == rightmost) {
				//leaf
				sum=a[leftmost];
			}
			else {
				//two children
				int mid = (leftmost+rightmost)/2;
				//the children will have ranges of [l,mid] and [mid+1,r]
				lChild = new SegTree(leftmost, mid,a);
				rChild = new SegTree(mid+1,rightmost,a);
				recalc();
			}
		}
		
		public void recalc() {
			if (leftmost == rightmost) {
				return;
				//sum is stored correctly as the nodes
			}
			sum=lChild.sum+rChild.sum;
		}
		public void pointUpdate(int index, int newVal) {
			if (leftmost == rightmost) {
				//leaf
				sum = newVal;
				return;
			}
			else {
				if (index<=lChild.rightmost) lChild.pointUpdate(index, newVal);
				else rChild.pointUpdate(index, newVal);
				recalc();
			}
		}
		public long rangeSum(int l, int r) {
			//entirely disjoint: query isn't in the range we are analyzing
			if (l>rightmost || r<leftmost) {
				return 0;
			}
			//range entirely covers the query.
			if (l<=leftmost && r>=rightmost) return sum;
			//we don't know. partially covered
			return lChild.rangeSum(l, r) + rChild.rangeSum(l, r);
		}
	}
	
	class Node {
		int L, R;
		long minVal, lazy;
		long oo = (long)1e18;
		Node left, right;
		
		Node(int lf, int rg, int[] arr) {
			L = lf;
			R = rg;
			if(L == R) {
				minVal = arr[L];
				return;
			}
			
			int mid = (lf + rg) / 2;
			
			left = new Node(lf, mid, arr);
			right = new Node(mid+1, rg, arr);
			
			minVal = Math.min(left.minVal, right.minVal);
		}
		
		long getVal() {
			return minVal + lazy;
		}
		
		void inc(int lf, int rg, int v) {
			if(rg < L || R < lf) return;
			if(lf <= L && R <= rg) {
				lazy += v;
				return;
			}
			propagate();
			
			left.inc(lf, rg, v);
			right.inc(lf, rg, v);
			min();
		}
		
		long rmq(int lf, int rg) {
			if(rg < L || R < lf) return oo;
			if(lf <= L && R <= rg) {
				return getVal();
			}
			propagate();
			long res = Math.min(left.rmq(lf, rg), right.rmq(lf, rg)); 
			min();
			return res;
		}
		
		void min() {
			minVal = Math.min(left.getVal(), right.getVal());
		}
		
		void propagate() {
			left.lazy += lazy;
			right.lazy += lazy;
			lazy = 0;
		}
	}
}
