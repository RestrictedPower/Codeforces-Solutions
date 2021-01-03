import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		long a = in.nextInt();
		long b = in.nextInt();
		long c = in.nextInt();
		long weeks = Math.min(Math.min(a/3, b/2),c/2);
		a-=weeks*3;
		b-=weeks*2;
		c-=weeks*2;
		long best = 0;
		for(int i = 0; i<2*7; i++) {
			long al = a, bl = b, cl = c;
			int j = i;
			boolean left = true;
			do {
				if(j%7==0||j%7==3||j%7==6) {
					left = al>0;
					al--;
				}else if(j%7==1||j%7==5) {
					left = bl>0;
					bl--;
				}else {
					left = cl>0;
					cl--;
				}
				if(left) j++;
			}while(j<14&&left);
			best = Math.max(j-i, best);
		}
		System.out.println(weeks*7+best);
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