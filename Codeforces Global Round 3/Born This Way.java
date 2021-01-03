import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		long n = in.nextInt(),m = in.nextInt(),Ta = in.nextInt(),Tb = in.nextInt(),k = in.nextInt();
		long[] a = in.nl((int) n);
		long[] b = in.nl((int) m);
		if(k>=n||k>=m) {
			System.out.println(-1);
			System.exit(0);
		}
		for(int i = 0; i<n; i++) a[i] +=Ta;
		long ans = -1;
		int idx = 0;
		for(int i = 0; i<=k; i++) {
			int ban2 = (int) (k-i);
			while(idx<m&&b[idx]<a[i])idx++;
			if(idx+ban2<m) ans = Math.max(ans, b[idx+ban2]+Tb);
			else {
				ans = -1;
				break;
			}
		}
		System.out.println(ans);
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