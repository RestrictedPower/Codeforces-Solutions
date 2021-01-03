import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt(), m = in.nextInt();
		boolean[][] A = new boolean[n][m];
		boolean[][] B = new boolean[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (in.nextInt() == 1)
					A[i][j] = true;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (in.nextInt() == 1)
					B[i][j] = true;
		boolean can = true;
		for (int i = 0; i < n && can; i++) {
			int cnt = 0;
			for (int j = 0; j < m && can; j++) {
				if (A[i][j] != B[i][j])
					cnt++;
			}
			if (cnt % 2 == 1)
				can = false;
		}
		for (int j = 0; j < m && can; j++) {
			int cnt = 0;
			for (int i = 0; i < n && can; i++) {
				if (A[i][j] != B[i][j])
					cnt++;
			}
			if (cnt % 2 == 1)
				can = false;
		}
		System.out.println(can?"Yes":"No");
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