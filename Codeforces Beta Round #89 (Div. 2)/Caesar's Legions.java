import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int MOD = 100000000;
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int k1 = in.nextInt();
		int k2 = in.nextInt();
		int[][][] dp = new int[n1 + 1][n2 + 1][2];
		dp[0][0][0] = 1; //0 = ending at i
		dp[0][0][1] = 1; //1 = ending at j
		for (int i = 0; i <= n1; i++) {
			for (int j = 0; j <= n2; j++) {
				for (int k = 1; k <= k1; k++) {
					if (i + k > n1)
						break;
					dp[i + k][j][0] += dp[i][j][1];
					dp[i + k][j][0] %= MOD;
				}
				for (int k = 1; k <= k2; k++) {
					if (j + k > n2)
						break;
					dp[i][j + k][1] += dp[i][j][0];
					dp[i][j + k][1] %= MOD;
				}
			}
		}
		int ans = (dp[n1][n2][0] + dp[n1][n2][1])%MOD;
		System.out.println(ans);
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