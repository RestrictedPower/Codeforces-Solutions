import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	final static long MOD = 998244353;
	static int[] size;
	static int[] parent;
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		int m = in.nextInt();
		size = new int[n+1];
		parent = new int[n+1];
		for(int i = 0; i<=n; i++) {
			size[i] = 1;
			parent[i] = i;
		}
		for(int i = 0; i<m; i++) {
			int k = in.nextInt();
			if(k==0) continue;
			int p = find(in.nextInt());
			for(int j = 0; j<k-1; j++) unite(p, in.nextInt());
		}
		for(int i = 1; i<=n; i++) {
			System.out.print(size[find(i)]+" ");
		}
	}
	public static int find(int i) {
		if(parent[i]==i) return i;
		return parent[i] = find(parent[i]);
	}
	public static void unite(int i, int j) {
		int pi = find(i);
		int pj = find(j);
		if(pi==pj) return;
		parent[pj] = pi;
		size[pi]+=size[pj];
	}


	static class Reader {
		static BufferedReader br;
		static StringTokenizer st;
		private int charIdx = 0;
		private String s;

		public Reader() {
			this.br = new BufferedReader(new InputStreamReader(System.in));
		}

		public int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public double[] nd(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++)
				a[i] = nextDouble();
			return a;
		}

		public char nextChar() {
			if (s == null || charIdx >= s.length()) {
				if (st == null || !st.hasMoreTokens())
					try {
						readLine();
					} catch (Exception e) {
					}
				s = st.nextToken();
				charIdx = 0;
			}
			return s.charAt(charIdx++);
		}

		public long[] nl(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public char[] nca() {
			return next().toCharArray();
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