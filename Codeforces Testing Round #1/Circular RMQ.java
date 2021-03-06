import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Random;
import java.io.PrintWriter;
/*
    Solution Created: 17:37:26 07/07/2019
    Custom Competitive programming helper.
*/
public class Main {
	static class SegmentTree{
		int n;
		int[] a,lo,hi;
		long[] tree,delta;
		public SegmentTree(int[] a) {
			this.n	= a.length;
			this.a = a;
			this.tree = new long[4*n];
			this.delta = new long[4*n];
			this.lo = new int[4*n];
			this.hi = new int[4*n];
			build(0, 0, n-1);
		}
		public void build(int node, int l,int r) {
			lo[node] = l;
			hi[node] = r;
			if(l==r)tree[node] = a[l];
			else {
				int mid = (l+r)/2;
				build(2*node+1, l, mid);
				build(2*node+2, mid+1, r);
				update(node);
			}
		}
		public long query(int node,int low, int high) {
			if(low<=lo[node]&&hi[node]<=high) return tree[node]+delta[node];
			if(high<lo[node]||hi[node]<low) return Long.MAX_VALUE;
			prop(node);
			long ans = Math.min(query(2*node+1, low, high) , query(2*node+2, low, high));
			update(node);
			return ans;
		}
		public void increment(int node,int low, int high,long val) {
			if(high<lo[node]||hi[node]<low) return;
			if(low<=lo[node]&&hi[node]<=high) {
				delta[node]+= val;
				return;
			}
			prop(node);
			increment(2*node+1, low, high, val);
			increment(2*node+2, low, high, val);
			update(node);
		}
		public void prop(int node) {
			delta[2*node+1]+=delta[node];
			delta[2*node+2]+=delta[node];
			delta[node] = 0;
		}
		public void update(int node) {
			tree[node] = Math.min(tree[2*node+1]+delta[2*node+1], tree[2*node+2]+delta[2*node+2]);
		}
	}
	public static void solve(Reader in, Writer out) {
		int n = in.nextInt();
		int[] a = in.na(n);
		SegmentTree st = new SegmentTree(a);
		int q = in.nextInt();
		while(q-->0) {
			String[] s = in.nextLine().split(" ");
			int l = Integer.parseInt(s[0]), r = Integer.parseInt(s[1]);
			if(s.length==2) {
				long ans;
				if(l<=r) ans = st.query(0, l, r);
				else ans = Math.min(st.query(0, 0, r), st.query(0, l, n-1));
				out.println(ans);
			}else {
				int v = Integer.parseInt(s[2]);
				if(l<=r)st.increment(0, l, r,v);
				else {
					st.increment(0, 0, r, v);
					st.increment(0, l, n-1, v);
				}
			}
		}
	}
	public static void main(String[] args) {
		Reader in = new Reader();
		Writer out = new Writer();
		solve(in, out);
		out.exit();
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
	private int charIdx = 0;
	private String s;

	public Reader() {
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}

	public int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	public double[] nd(int n) {
		double[] a = new double[n];
		for (int i = 0; i < n; i++)
			a[i] = nextDouble();
		return a;
	}

	public char nextChar() {
		if (s == null || charIdx >= s.length()) {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			s = st.nextToken();
			charIdx = 0;
		}
		return s.charAt(charIdx++);
	}

	public long[] nl(int n) {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nextLong();
		return a;
	}

	public char[] nca() {
		return next().toCharArray();
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
	public String nextLine() {
		if (st == null || !st.hasMoreTokens())
			try {
				readLine();
			} catch (Exception e) {
			}
		String ans = "";
		while(st.hasMoreTokens()) ans+=st.nextToken()+" ";
		return ans;
	}
	public static void readLine() {
		try {
			st = new StringTokenizer(br.readLine());
		} catch (Exception e) {
		}
	}
}

static class Sort {
	static Random random = new Random();
	public static void sortArray(int[] s) {
        shuffle(s);
        Arrays.sort(s);
    }
	public static void sortArray(long[] s) {
        shuffle(s);
        Arrays.sort(s);
    }
	public static void sortArray(String[] s) {
        shuffle(s);
        Arrays.sort(s);
    }
	public static void sortArray(char[] s) {
        shuffle(s);
        Arrays.sort(s);
    }
    private static void shuffle(int[] s) {
        for (int i = 0; i < s.length; ++i) {
            int j = random.nextInt(i + 1);
            int t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
    private static void shuffle(long[] s) {
        for (int i = 0; i < s.length; ++i) {
            int j = random.nextInt(i + 1);
            long t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
    private static void shuffle(String[] s) {
        for (int i = 0; i < s.length; ++i) {
            int j = random.nextInt(i + 1);
            String t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
    private static void shuffle(char[] s) {
        for (int i = 0; i < s.length; ++i) {
            int j = random.nextInt(i + 1);
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}

static class Util{
	    static boolean isPrime(int n) { 
	        if (n <= 1) return false; 
	        if (n <= 3) return true; 
	        if (n % 2 == 0 || n % 3 == 0) return false; 
	        for (int i = 5; i * i <= n; i = i + 6) 
	            if (n % i == 0 || n % (i + 2) == 0) 
	            return false; 
	        return true; 
	    }
		public static int upperBound(long[] a, long v) {
			if(a[0]>v) return -1;
			int l=0,h=a.length-1;
			while(l<h) {
				int mid = (l+h)/2;
				if(v>=a[mid]) l = mid+1;
				else h = mid-1;
			}
			if(v<a[l]) return l-1;
			return l;
		}
		public static int lowerBound(long[] a, int v) {
			if(a[a.length-1]<v) return -1;
			int l=0,h=a.length-1;
			while(l<h) {
				int mid = (l+h)/2;
				if(v<=a[mid]) h = mid-1;
				else l = mid+1;
			}
			if(v>a[l]) return l+1;
			return l;
		}
	    public static boolean[] getSieve(int n) {
	        boolean[] isPrime = new boolean[n+1];
	        for (int i = 2; i <= n; i++) isPrime[i] = true;
	        for (int i = 2; i*i <= n; i++) if (isPrime[i]) 
	                for (int j = i; i*j <= n; j++) isPrime[i*j] = false;
	        return isPrime;
	    }
	    public static int gcd(int a, int b) { 
	        if (a == 0) 
	            return b; 
	        return gcd(b%a, a); 
	    }
		public static long modAdd(long a, long b, long mod) {
			return (a%mod+b%mod)%mod;
		}
		public static long modMul(long a, long b, long mod) {
			return ((a%mod)*(b%mod))%mod;
		}
		public static void dbg(Object... o) { 
			System.out.println(Arrays.deepToString(o)); 
		}
	}

static class Writer {
	private PrintWriter pw;
	public Writer(){
		pw = new PrintWriter(System.out);
	}
	
	public void printArray(int[] a) {
		for(int i = 0; i<a.length; i++) print(a[i]+" ");
	}
	public void printlnArray(int[] a) {
		for(int i = 0; i<a.length; i++) print(a[i]+" ");
		pw.println();
	}
	public void printArray(long[] a) {
		for(int i = 0; i<a.length; i++) print(a[i]+" ");
	}
	public void printlnArray(long[] a) {
		for(int i = 0; i<a.length; i++) print(a[i]+" ");
		pw.println();
	}
	public void print(Object o) {
		pw.print(o.toString());
	}
	public void println(Object o) {
		pw.println(o.toString());
	}
	public void println() {
		pw.println();
	}
	public void flush() {
		pw.flush();
	}
	public void exit() {
		pw.close();
	}
}
}