import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		int m = in.nextInt();
		boolean dif = false;
		int idx1 = 0;
		int idx2 = 0;
		int v1 = 0;
		int ans = 0;
		int midx=0;
		for(int i = 0; i<n; i++) {
			Pair[] ar = new Pair[m];
			for(int j = 0; j<m; j++) ar[j] = new Pair(j, in.nextInt());
			int fst = ar[0].val;
			if(!dif) {
				Arrays.sort(ar);
				for(int j = 0; j<m-1;j++)
					if(ar[j].val!=ar[j+1].val) {
						dif = true;
						idx1 = ar[j].idx;
						idx2 = ar[j+1].idx;
						v1 = ar[j].val;
						midx = i;
						break;
					}
				if(!dif) {
					ans^=fst;
				}
			}else {
				ans^=fst;
			}
		}
		if(!dif&&ans==0) {
			System.out.println("NIE");
		}else {
			System.out.println("TAK");
			for(int i = 0; i<n; i++) {
				if(i!=midx) System.out.print(1+" ");
				else {
					if((v1^ans)!=0) {
						System.out.print((idx1+1)+" ");
					}else System.out.print((idx2+1)+" ");
				}
			}
		}
	}

	static class Pair implements Comparable<Pair>{
		int idx;
		int val;
		public Pair(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		@Override
		public int compareTo(Pair o) {
			return this.val - o.val;
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