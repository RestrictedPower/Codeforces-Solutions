import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int t = in.nextInt();
		while(t-->0) {
			int n = in.nextInt();
			long[] a = in.nl(n);
			ArrayList<Long> va = new ArrayList<>();
			ArrayList<Long> vb = new ArrayList<>();
			for(int i = 0; i<n; i++) va.add(a[i]);
			mySort(a);
			long num = a[0]*a[n-1];
			for(long i = 2; i<=Math.sqrt(num); i++) {
				if(num%i==0) {
					vb.add(i);
					if(num/i!=i) vb.add(num/i);
				}
			}
			Collections.sort(va);
			Collections.sort(vb);
			if(va.equals(vb)) System.out.println(num);
			else System.out.println(-1);
		}
	}

	public static void mySort(long[] a) {
		Random r = new Random();
		int count = a.length;
		for (int i = count; i > 1; i--) {
			int idx = r.nextInt(i);
			long temp = a[i-1];
			a[i-1] = a[idx];
			a[idx] = temp;
		}
		Arrays.sort(a);
	}
	public static class FCP {
		long[] fact;

		public FCP(int maxn) {
			fact = new long[maxn + 1];
			Arrays.fill(fact, -1);
			fact[0] = 1;
		}

		public long factorial(int x) {
			if (fact[x] != -1)
				return fact[x];
			return fact[x] = (x * factorial(x - 1));
		}

		public long C(int n, int k) {
			return P(n, k) / factorial(k);
		}

		public long P(int n, int k) {
			return (factorial(n) / factorial(n - k));
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