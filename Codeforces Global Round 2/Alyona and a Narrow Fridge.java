import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.plaf.ActionMapUIResource;

import javafx.scene.layout.Priority;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		int h = in.nextInt();
		int[] a = in.na(n);
		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		boolean cont = true;
		for(int i = 0; i<n&&cont; i++) {
			pq.add(a[i]);
			int curh = 0;
			boolean one = true;
			int last = -1;
			PriorityQueue<Integer> ps = new PriorityQueue<>(Collections.reverseOrder());
			for(Integer v : pq) ps.add(v) ;
			while(!ps.isEmpty()) {
				int v = ps.poll();
				if(one) {
					if(curh+v<=h) {
						curh+=v;
					}else {
						cont = false;
						break;
					}
				}else {
					if(curh+v-last<=h) {
						curh+=Math.max(last, v)-last;
					}else {
						cont = false;
						break;
					}
				}
				last = v;
				one = !one;
			}
			if(cont) ans = Math.max(ans,pq.size());
		}
		System.out.println(ans);
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