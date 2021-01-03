import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		int[] a = in.na(n);
		int[] f1 = new int[100005];
		int[] f2 = new int[100005];
		int ans = 0;
		int diff = 0;
		for(int i = 0; i<n; i++) {
			if(f2[f1[a[i]]]!=0) {
				f2[f1[a[i]]]--;
				if(f2[f1[a[i]]]==0) diff--;
			}
			f1[a[i]]++;
			if(f2[f1[a[i]]]==0) diff++;
			f2[f1[a[i]]]++;
			int curF = f1[a[i]];
			if(diff==2 && f2[1]==1) ans = i+1;
			if(diff==2 && f2[curF-1]!=0 && f2[curF]==1) ans = i+1;
			if(diff==2 && f2[curF]!=0 && f2[curF+1]==1) ans = i+1;
			if(diff==1 && (curF==1||f2[curF]==1)) ans = i+1;
		}
		System.out.println(ans);
	}
	public static class FCP{
		long[] fact;
		public FCP(int maxn) {
			fact = new long[maxn+1];
			Arrays.fill(fact, -1);
			fact[0] = 1; 
		}
		public long factorial(int x) {
			if(fact[x]!=-1) return fact[x];
			return fact[x] = (x*factorial(x-1));
		}
		public long C(int n, int k) {
			return P(n,k)/factorial(k);
		}
		public long P(int n, int k) {
			return (factorial(n)/factorial(n-k));
		}
	}
	static class Reader {
		static BufferedReader br;
		static StringTokenizer st;

		public Reader() {
			this.br = new BufferedReader(new InputStreamReader(System.in));
		}

		public int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public long[] nl(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public String[] nS(int n) {
			String[] a = new String[n];
			for (int i = 0; i < n; i++)
				a[i] = next();
			return a;
		}

		public int nextInt() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return Integer.parseInt(st.nextToken());
		}

		public double nextDouble() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return Double.parseDouble(st.nextToken());
		}

		public Long nextLong() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return Long.parseLong(st.nextToken());
		}

		public String next() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return st.nextToken();
		}

		public static void readLine() {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
			}
		}
	}
}