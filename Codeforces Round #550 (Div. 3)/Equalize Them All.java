import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		int[] a = in.na(n);
		int max = mostFrequent(a, a.length);
		boolean[] here = new boolean[n + 1];
		int times = 0;
		for (int i = 0; i < n; i++)
			if (a[i] == max) {
				times++;
				here[i] = true;
			}
		System.out.println(n - times);
		for (int i = 0; i < n - 1; i++) {
			if (here[i] && !here[i + 1]) {
				here[i + 1] = true;
				if (a[i] < a[i + 1]) {
					System.out.println(2 + " " + (i + 2) + " " + (i + 1));
					a[i + 1] = a[i];
				} else {
					System.out.println(1 + " " + (i + 2) + " " + (i + 1));
					a[i + 1] = a[i];
				}
			}
		}
		for (int i = n - 1; i > 0; i--) {
			if (here[i] && !here[i - 1]) {
				here[i - 1] = true;
				if (a[i] < a[i - 1]) {
					System.out.println(2 + " " + i + " " + (i + 1));
					a[i - 1] = a[i];
				} else {
					System.out.println(1 + " " + i + " " + (i + 1));
					a[i - 1] = a[i];
				}
			}
		}
	}

	static int mostFrequent(int arr[], int n) {
		Map<Integer, Integer> hp = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int key = arr[i];
			if (hp.containsKey(key)) {
				int freq = hp.get(key);
				freq++;
				hp.put(key, freq);
			} else {
				hp.put(key, 1);
			}
		}
		int max_count = 0, res = -1;
		for (Entry<Integer, Integer> val : hp.entrySet()) {
			if (max_count < val.getValue()) {
				res = val.getKey();
				max_count = val.getValue();
			}
		}
		return res;
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