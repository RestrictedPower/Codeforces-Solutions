import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Random;
import java.io.FileWriter;
import java.io.PrintWriter;
/*
    Solution Created: 20:51:54 12/07/2020
    Custom Competitive programming helper.
*/

public class Main {
	static long n, m, fireballCost, fireballLen, berserkCost;
	static boolean worthToRemoveOneByOne = false;
	public static void solve(Reader in, Writer out) {
		n = in.nextInt();
		m = in.nextInt();
		fireballCost =in.nextInt();
		fireballLen = in.nextInt();
		berserkCost = in.nextInt();
		int[] a = in.na((int) n), b = in.na((int) m);
		if(fireballCost>=fireballLen*berserkCost) worthToRemoveOneByOne = true;
		int[] pos = new int[(int) (n+1)];
		Arrays.fill(pos, -1);
		for(int i = 0; i<n; i++) pos[a[i]] = i;
		if(pos[b[0]]==-1 || pos[b[(int) (m-1)]]==-1) exitFalse();
		ArrayList<Integer> values = new ArrayList<Integer>();
		for(int i = 0; i!=pos[b[0]]; i++) values.add(a[i]);
		long ans = 0;
		long cost = rangeCost(Integer.MIN_VALUE, b[0], values);
		if(cost == -1) exitFalse();
		ans+= cost;
		
		values.clear();
		for(int i = (int) (n-1); i!=pos[b[(int) (m-1)]]; i--) values.add(a[i]);
		cost = rangeCost(b[(int) (m-1)], Integer.MIN_VALUE, values);
		if(cost == -1) exitFalse();
		ans+= cost;
		for(int i = 0; i<m-1; i++) {
			int l = b[i], r = b[i+1];
			if(pos[l]>pos[r]) exitFalse();
			values.clear();
			for(int j = pos[l]+1; j<pos[r]; j++) values.add(a[j]);
			cost = rangeCost(b[i], b[i+1], values);
			if(cost == -1) exitFalse();
			ans+= cost;
		}
		out.println(ans);
	}
	public static void exitFalse() {
		System.out.println(-1);
		System.exit(0);
	}
	public static long rangeCost(long lBorder, long rBorder, ArrayList<Integer> a) {
		long maxRem = Math.max(lBorder, rBorder);
		long maxIn = 0;
		for(Integer i  : a) maxIn = Math.max(maxIn, i);
		if(maxRem>maxIn) {
			if(worthToRemoveOneByOne) return a.size()*berserkCost;
			return (a.size()/fireballLen)*fireballCost + (a.size()%fireballLen)*berserkCost;
		}
		if(a.size()<fireballLen) return -1;
		if(worthToRemoveOneByOne) return (a.size()-fireballLen)*berserkCost + fireballCost;
		return (a.size()/fireballLen)*fireballCost + (a.size()%fireballLen)*berserkCost;
	}
	public static void main(String[] args) {
		Reader in = new Reader();
		Writer out = new Writer();
		solve(in, out);
		out.exit();
	}

static class Reader {
	static BufferedReader br;
	static StringTokenizer st;
	private int charIdx = 0;
	private String s;

	public Reader() {
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Reader(String f){
		try {
			this.br = new BufferedReader(new FileReader(f));
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public static void readLine() {
		try {
			st = new StringTokenizer(br.readLine());
		} catch (Exception e) {
		}
	}
}

static class Util{
		private static Random random = new Random();
		static long[] fact;
		public static void initFactorial(int n, long mod) {
			fact = new long[n+1];
			fact[0] = 1;
			for (int i = 1; i < n+1; i++) fact[i] = (fact[i - 1] * i) % mod;
		}
		public static long modInverse(long a, long MOD) {
			long[] gcdE = gcdExtended(a, MOD);
			if (gcdE[0] != 1) return -1; // Inverted doesn't exist
			long x = gcdE[1];
			return (x % MOD + MOD) % MOD;
		}
		public static long[] gcdExtended(long p, long q) {
			if (q == 0) return new long[] { p, 1, 0 };
			long[] vals = gcdExtended(q, p % q);
			long tmp = vals[2];
			vals[2] = vals[1] - (p / q) * vals[2];
			vals[1] = tmp;
			return vals;
		}
		public static long nCr(int n, int r, long MOD) {
			if (r == 0) return 1;
			return (fact[n] * modInverse(fact[r], MOD) % MOD * modInverse(fact[n - r], MOD) % MOD) % MOD;
		}
		public static long nCr(int n, int r) {
			return (fact[n]/fact[r])/fact[n-r];
		}
		public static long nPr(int n, int r, long MOD) {
			if (r == 0) return 1;
			return (fact[n] * modInverse(fact[n - r], MOD) % MOD) % MOD;
		}
		public static long nPr(int n, int r) {
			return fact[n]/fact[n-r];
		}
		public static boolean isPrime(int n) { 
	        if (n <= 1) return false; 
	        if (n <= 3) return true; 
	        if (n % 2 == 0 || n % 3 == 0) return false; 
	        for (int i = 5; i * i <= n; i = i + 6) 
	            if (n % i == 0 || n % (i + 2) == 0) 
	            return false; 
	        return true; 
	    }
	    public static int lowerBound(int[] a, int v) {
	    	int l = 0, h = a.length;
	    	while(l<h) {
	    		int mid = (l+h)/2;
	    		if(v<=a[mid]) h = mid;
	    		else l = mid+1;
	    	}
	    	return l;
	    }
	    public static int lowerBound(long[] a, long v) {
	    	int l = 0, h = a.length;
	    	while(l<h) {
	    		int mid = (l+h)/2;
	    		if(v<=a[mid]) h = mid;
	    		else l = mid+1;
	    	}
	    	return l;
	    }
	    public static int upperBound(int[] a, int v) {
	    	int l = 0, h = a.length;
	    	while(l<h) {
	    		int mid = (l+h)/2;
	    		if(a[mid]<=v) l = mid+1;
	    		else h = mid;
	    	}
	    	return l;
	    }
	    public static int upperBound(long[] a, long v) {
	    	int l = 0, h = a.length;
	    	while(l<h) {
	    		int mid = (l+h)/2;
	    		if(a[mid]<=v) l = mid+1;
	    		else h = mid;
	    	}
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
	    	int tmp = 0;
	    	while(b != 0) {
	    		tmp = b;
	    		b = a%b;
	    		a = tmp;
	    	}
	    	return a;
	    }
	    public static long gcd(long a, long b) { 
	    	long tmp = 0;
	    	while(b != 0) {
	    		tmp = b;
	    		b = a%b;
	    		a = tmp;
	    	}
	    	return a;
	    }
	    public static int random(int min, int max) {
	    	return random.nextInt(max-min+1)+min;
	    }
		public static void dbg(Object... o) { 
			System.out.println(Arrays.deepToString(o)); 
		}
		public static void reverse(int[] s, int l , int r) {
			for(int i = l; i<=(l+r)/2; i++) {
				int tmp = s[i];
				s[i] = s[r+l-i];
				s[r+l-i] = tmp;
			}
	    }
		public static void reverse(int[] s) {
			reverse(s, 0, s.length-1);
	    }
		public static void reverse(long[] s, int l , int r) {
			for(int i = l; i<=(l+r)/2; i++) {
				long tmp = s[i];
				s[i] = s[r+l-i];
				s[r+l-i] = tmp;
			}
	    }
		public static void reverse(long[] s) {
			reverse(s, 0, s.length-1);
	    }
		public static void reverse(float[] s, int l , int r) {
			for(int i = l; i<=(l+r)/2; i++) {
				float tmp = s[i];
				s[i] = s[r+l-i];
				s[r+l-i] = tmp;
			}
	    }
		public static void reverse(float[] s) {
			reverse(s, 0, s.length-1);
	    }
		public static void reverse(double[] s, int l , int r) {
			for(int i = l; i<=(l+r)/2; i++) {
				double tmp = s[i];
				s[i] = s[r+l-i];
				s[r+l-i] = tmp;
			}
	    }
		public static void reverse(double[] s) {
			reverse(s, 0, s.length-1);
	    }
		public static void reverse(char[] s, int l , int r) {
			for(int i = l; i<=(l+r)/2; i++) {
				char tmp = s[i];
				s[i] = s[r+l-i];
				s[r+l-i] = tmp;
			}
	    }
		public static void reverse(char[] s) {
			reverse(s, 0, s.length-1);
	    }
		public static <T> void reverse(T[] s, int l , int r) {
			for(int i = l; i<=(l+r)/2; i++) {
				T tmp = s[i];
				s[i] = s[r+l-i];
				s[r+l-i] = tmp;
			}
	    }
		public static <T> void reverse(T[] s) {
			reverse(s, 0, s.length-1);
	    }
		public static void shuffle(int[] s) {
	        for (int i = 0; i < s.length; ++i) {
	            int j = random.nextInt(i + 1);
	            int t = s[i];
	            s[i] = s[j];
	            s[j] = t;
	        }
	    }
	    public static void shuffle(long[] s) {
	        for (int i = 0; i < s.length; ++i) {
	            int j = random.nextInt(i + 1);
	            long t = s[i];
	            s[i] = s[j];
	            s[j] = t;
	        }
	    }
	    public static void shuffle(float[] s) {
	        for (int i = 0; i < s.length; ++i) {
	            int j = random.nextInt(i + 1);
	            float t = s[i];
	            s[i] = s[j];
	            s[j] = t;
	        }
	    }
	    public static void shuffle(double[] s) {
	        for (int i = 0; i < s.length; ++i) {
	            int j = random.nextInt(i + 1);
	            double t = s[i];
	            s[i] = s[j];
	            s[j] = t;
	        }
	    }
	    public static void shuffle(char[] s) {
	        for (int i = 0; i < s.length; ++i) {
	            int j = random.nextInt(i + 1);
	            char t = s[i];
	            s[i] = s[j];
	            s[j] = t;
	        }
	    }
	    public static <T> void shuffle(T[] s) {
	        for (int i = 0; i < s.length; ++i) {
	            int j = random.nextInt(i + 1);
	            T t = s[i];
	            s[i] = s[j];
	            s[j] = t;
	        }
	    }
		public static void sortArray(int[] a) {
	        shuffle(a);
	        Arrays.sort(a);
	    }
		public static void sortArray(long[] a) {
			shuffle(a);
	        Arrays.sort(a);
	    }
		public static void sortArray(float[] a) {
			shuffle(a);
	        Arrays.sort(a);
	    }
		public static void sortArray(double[] a) {
			shuffle(a);
	        Arrays.sort(a);
	    }
		public static void sortArray(char[] a) {
			shuffle(a);
	        Arrays.sort(a);
	    }
		public static <T extends Comparable<T>> void sortArray(T[] a) {
	        Arrays.sort(a);
	    }
	}

static class Writer {
	private PrintWriter pw;
	public Writer(){
		pw = new PrintWriter(System.out);
	}
	
	public Writer(String f){
		try {
			pw = new PrintWriter(new FileWriter(f));
		} catch (IOException e) {
			e.printStackTrace();
		}
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