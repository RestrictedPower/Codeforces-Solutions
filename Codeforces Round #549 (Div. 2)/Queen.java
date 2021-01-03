import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		ArrayList<Integer>[] ch = new ArrayList[n+1];
		for (int i = 0; i <= n; ++i)
			ch[i] = new ArrayList();
		boolean[] rem = new boolean[n+1];
		boolean[] resp = new boolean[n+1];
		int[] toRem = new int[n];
		int len = 0;
		for(int i = 1; i<=n; i++) {
			int v = in.nextInt();
			if(v!=-1) ch[v].add(i);
			rem[i] = in.nextInt()==1;
			if(rem[i]) toRem[len++] = i;
		}
		for(int idx = 1; idx<=n; idx++) {
			resp[idx] = false;
			for(Integer i : ch[idx]) {
				if(!rem[i]) resp[idx] = true;
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0; i<len; i++) {
			int next = toRem[i];
			if(!resp[next]) ans.add(next);
		}
		if(ans.size() == 0) {
			System.out.println(-1);
		}else {
			for(Integer i : ans) System.out.print(i+" ");
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