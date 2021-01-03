import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] max;
	static ArrayList<Integer> con[];
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		con = new ArrayList[n+1];
		for (int i = 0; i <=n; ++i) con[i] = new ArrayList();
		max = new boolean[n+1];
		for(int i = 1; i<=n; i++) max[i] = in.nextInt()==1;
		for(int i = 2; i<=n; i++) {
			con[in.nextInt()].add(i);
		}
		int k = 0;
		for(int i = 1; i<=n; i++) {
			if(con[i].size()==0) k++;
		}
		int v = dfs(1);
		//System.out.println(k);
		System.out.println((k-v+1));
	}
	public static int dfs(int cur) {
		int conLen = con[cur].size();
		if(conLen==0) return 1;
		if(max[cur]) {
			int min = Integer.MAX_VALUE;
			for(Integer i : con[cur]) min = Math.min(min, dfs(i));
			return min;
		}else {
			int tot = 0;
			for(Integer i : con[cur]) tot+=dfs(i);
			return tot;
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