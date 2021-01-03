import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		int z = in.nextInt();
		int[] a = in.na(n);
		shuffleArray(a);
		Arrays.sort(a);
		int l = 0;
		int r = n/2;
		while(l<r) {
			int mid = (l+r+1)/2;
			if(can(a,mid,z)) l = mid;
			else r = mid-1;
		}
		System.out.println(l);
	}
	static void shuffleArray(int[] arr){
        int n = arr.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
        	int tmp = arr[i];
            int randomPos = i + rnd.nextInt(n-i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }   
	}
	public static boolean can(int[] a, int k,int z) {
		int n = a.length;
		for(int i = 0; i<k; i++) {
			if(a[n-k+i]-a[i]<z) return false;
		}
		return true;
	}
	public static class Util {
		static boolean isPrime(int n) {
			if (n <= 1)
				return false;
			if (n <= 3)
				return true;
			if (n % 2 == 0 || n % 3 == 0)
				return false;
			for (int i = 5; i * i <= n; i = i + 6)
				if (n % i == 0 || n % (i + 2) == 0)
					return false;
			return true;
		}

		public static int upperBound(int[] a, int v) {
			if (a[0] > v)
				return -1;
			int l = 0, h = a.length - 1;
			while (l < h) {
				int mid = (l + h) / 2;
				if (v >= a[mid])
					l = mid + 1;
				else
					h = mid - 1;
			}
			if (v < a[l])
				return l - 1;
			return l;
		}

		public static int lowerBound(int[] a, int v) {
			if (a[a.length - 1] < v)
				return -1;
			int l = 0, h = a.length - 1;
			while (l < h) {
				int mid = (l + h) / 2;
				if (v <= a[mid])
					h = mid - 1;
				else
					l = mid + 1;
			}
			if (v > a[l])
				return l + 1;
			return l;
		}

		public static boolean[] getSieve(int n) {
			boolean[] isPrime = new boolean[n + 1];
			for (int i = 2; i <= n; i++)
				isPrime[i] = true;
			for (int i = 2; i * i <= n; i++)
				if (isPrime[i])
					for (int j = i; i * j <= n; j++)
						isPrime[i * j] = false;
			return isPrime;
		}

		public static int gcd(int a, int b) {
			if (a == 0)
				return b;
			return gcd(b % a, a);
		}

		public static long modAdd(long a, long b, long mod) {
			return (a % mod + b % mod) % mod;
		}

		public static long modMul(long a, long b, long mod) {
			return ((a % mod) * (b % mod)) % mod;
		}
	}

	static class Graph {
		private ArrayList<Integer> con[];
		private boolean[] visited;

		public Graph(int n) {
			con = new ArrayList[n];
			for (int i = 0; i < n; ++i)
				con[i] = new ArrayList();
			visited = new boolean[n];
		}

		public void reset() {
			Arrays.fill(visited, false);
		}

		public void addEdge(int v, int w) {
			con[v].add(w);
		}

		public void dfs(int cur) {
			visited[cur] = true;
			for (Integer v : con[cur]) {
				if (!visited[v]) {
					dfs(v);
				}
			}
		}

		public void bfs(int cur) {
			Queue<Integer> q = new LinkedList<>();
			q.add(cur);
			visited[cur] = true;
			while (!q.isEmpty()) {
				cur = q.poll();
				for (Integer v : con[cur]) {
					if (!visited[v]) {
						visited[v] = true;
						q.add(v);
					}
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