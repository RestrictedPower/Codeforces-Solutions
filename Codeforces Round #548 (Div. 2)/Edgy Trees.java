import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class Main {
	static int[] par;
	static long[] len;
	static long mod = 1000000007;

	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		int k = in.nextInt();
		par = new int[n+1];
		len = new long[n+1];
		for(int i = 0; i<=n; i++) {
			par[i] = i;
			len[i] = 1;
		}
		long ans = power(n, k, mod)%mod;
		for(int i = 0; i<n-1; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			if(c==0) unite(a, b);
		}
		long rem = 0;
		for(int i = 1; i<=n; i++) if(par[i]==i) rem=(rem+power(len[i], k, mod))%mod;
		ans = (ans - rem + mod) % mod;
		System.out.println(ans);
	}

	public static int find(int x) {
		if (par[x] == x)
			return x;
		return find(par[x]);
	}

	public static void unite(int a, int b) {
		int p1 = find(a);
		int p2 = find(b);
		if(p1==p2) return;
		par[p2] = p1;
		len[p1] += len[p2];
	}

	static long power(long x, long y, long p) {
		long res = 1;
		x = x % p;
		while (y > 0) {
			if ((y & 1) == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
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