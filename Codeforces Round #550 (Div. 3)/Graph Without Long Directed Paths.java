import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int parent[];
	static int n;
	public static void main(String[] args) {
		Reader in = new Reader();
		 n = in.nextInt();
		int m = in.nextInt();
		Graph g = new Graph(n);
		int[][] a = new int[m][2];
		for(int i = 0; i<m; i++) {
			int v1 = in.nextInt()-1;
			int v2 = in.nextInt()-1;
			a[i][0] = v1;
			a[i][1] = v2;
			g.addEdge(v1, v2);
		}
		for(int i = 0; i<n; i++) g.dfs(i, true);
		char[] ans = new char[m];
		int len = 0;
		boolean ok = true;
		for(int i = 0; i<m&&ok;i++) {
			if(g.move[a[i][0]]==g.move[a[i][1]]) {
				ok = false;
			}else {
				if(g.move[a[i][0]])ans[len++] = '1';
				else ans[len++] = '0';
			}
		}
		if(ok) {
			System.out.println("YES");
			for(char c : ans) System.out.print(c);
		}else
			System.out.println("NO");
	}
	static class Graph {
		private ArrayList<Integer> con[];
		boolean[] move;
		private boolean[] visited;
		public Graph(int n) {
			con = new ArrayList[n];
			for (int i = 0; i < n; ++i)
				con[i] = new ArrayList();
			move = new boolean[n];
			visited = new boolean[n];
		}
		public void reset() {
			Arrays.fill(visited, false);
		}
		public void addEdge(int v, int w) {
			con[v].add(w);
			con[w].add(v);
		}
		public void dfs(int cur,boolean m) {
			if(visited[cur]) return;
			move[cur] = m;
			visited[cur] = true;
			if(!con[cur].isEmpty())
			for (Integer v : con[cur]) {
				if (!visited[v]) {
					dfs(v,!m);
				}
			}
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