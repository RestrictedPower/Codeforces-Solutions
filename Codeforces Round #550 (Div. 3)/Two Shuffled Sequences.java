import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		int[] a = in.na(n);
		Stack<Integer> inc = new Stack<>();
		Stack<Integer> dec = new Stack<>();
		Arrays.sort(a);
		boolean ok = true;
		for(int i = 0; i<n&&ok; i++) {
			if(inc.isEmpty()) {
				inc.push(a[i]);
			}else if(dec.isEmpty()) {
				dec.push(a[i]);
			}else if(inc.peek()>dec.peek()) {
				if(inc.peek()<a[i]) {
					inc.push(a[i]);
				}else if(dec.peek()<a[i]) {
					dec.push(a[i]);
				}else ok = false;
			}else if(inc.peek()<=dec.peek()) {
				if(dec.peek()<a[i]) {
					dec.push(a[i]);
				}else if(inc.peek()<a[i]) {
					inc.push(a[i]);
				}else ok = false;
			}else ok = false;
		}
		if(!ok) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
			System.out.println(inc.size());
			for(int j = 0; j<inc.size(); j++) System.out.print(inc.get(j)+" ");
			System.out.println();
			System.out.println(dec.size());
			for(int j = 0; j<dec.size(); j++) System.out.print(dec.get(dec.size()-j-1)+" ");
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