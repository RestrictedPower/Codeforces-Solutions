import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int[] v = in.na(4);
		Arrays.sort(v);
		for(int a = 0; a<4; a++) 
			for(int b = 0; b<4; b++)
				for(int c = 0; c<4; c++)
					for(int d = 0; d<4; d++) {
						if(a==b||a==c||a==d||b==c||c==d)continue;
						int[] ans = new int[3];
						int[] va = new int[4];
						va[0] = v[a];
						va[1] = v[b];
						va[2] = v[c];
						va[3] = v[d];
						ans[0] = va[3] - va[2];
						ans[1] = va[0]-ans[0];
						ans[2] = va[2] - ans[1];
						if(valid(va, ans)) {
							for(int i = 0; i<3; i++) System.out.print(ans[i]+" ");
							System.exit(0);
						}
					}
		
	}
	public static boolean valid(int[] v, int[] ans) {
		if(ans[1]+ans[0]!=v[0]) return false;
		if(ans[0]+ans[2]!=v[1]) return false;
		if(ans[1]+ans[2]!=v[2]) return false;
		if(ans[0]+ans[1]+ans[2]!=v[3]) return false;
		return true;
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