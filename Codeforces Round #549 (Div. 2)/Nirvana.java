import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		String s = in.next();
		String[] sx = s.split("");
		int n = s.length();
		int[] a = new int[n];
		for(int i = 0; i<n; i++)
			a[i] = Integer.parseInt(sx[i]);
		long ans = 1;
		for(int i = 0; i<n; i++) ans*=a[i];
		long prev = 1;
		for(int i = 0; i<n; i++) {
			if(a[i]==1) {
				ans = (long) Math.max(ans, Math.pow(9,n-i-1));
			}else if(a[i]!=0) {
				ans = (long) Math.max(ans, prev*Math.pow(9,n-i-1)*(a[i]-1));
				prev*=a[i];
			}else break;
		}
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