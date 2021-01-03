import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		int k = in.nextInt();
		Pair[] a = new Pair[n];
		for(int i = 0; i<n; i++) a[i] = new Pair(in.nextInt(), in.nextInt());
		Arrays.sort(a);
		long[] s = new long[n];
		s[0] = a[0].l;
		for(int i = 1; i<n; i++) {
			s[i] = s[i-1];
			s[i]+=a[i].l;
		}
		long ans = 0;
		long sumrem = 0;
		PriorityQueue<Pair2> remove = new PriorityQueue<>();
		for(int i = 0; i<n; i++) {
			if(i>=k) {
				Pair2 pr = remove.poll();
				sumrem+=pr.l;
			}
			ans = Math.max(ans, (s[i]-sumrem)*a[i].b);
			Pair2 pr = new Pair2(a[i].l, a[i].b);
			remove.add(pr);
		}
		System.out.println(ans);
	}
	static class Pair implements Comparable<Pair>{
		int l,b;
		public Pair(int le, int be) {
			this.l = le;
			this.b = be;
		}
		@Override
		public int compareTo(Pair o) {
			return o.b-this.b;
		}
	}
	static class Pair2 implements Comparable<Pair2>{
		int l,b;
		public Pair2(int le, int be) {
			this.l = le;
			this.b = be;
		}
		@Override
		public int compareTo(Pair2 o) {
			return this.l-o.l;
		}
	}
	public static void ex() {
		System.exit(0);
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