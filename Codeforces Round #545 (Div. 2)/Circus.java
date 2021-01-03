import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.plaf.ActionMapUIResource;

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		String st1 = in.next();
		String st2 = in.next();
		Stack<Integer>[] a = new Stack[4];
		for(int i = 0; i<4; i++) a[i] = new Stack<>();
		for(int i = 0; i<n; i++) {
			if(st1.charAt(i)==st2.charAt(i)) {
				if(st1.charAt(i)=='0') a[0].push(i+1);
				else a[3].push(i+1);
			}else{
				if(st1.charAt(i)=='1')a[1].push(i+1);
				else a[2].push(i+1);
			}
		}
		boolean solved = false;
		ArrayList<Integer> ans = new ArrayList<>();
		int none = a[0].size();
		int cl = a[1].size();
		int ac = a[2].size();
		int both = a[3].size();
		for(int bothAsClowns = 0; bothAsClowns<=both&&!solved; bothAsClowns++) {
			for(int clownsUsed = 0; clownsUsed<=cl&&!solved; clownsUsed++) {
				int total1 = bothAsClowns, total2 = both - bothAsClowns;
				int actual1 = total1 , actual2 = total2;
				total1+=clownsUsed;
				total2+=cl-clownsUsed;
				actual1+=clownsUsed;
				//System.out.println(actual1+" "+actual2+" DAB1");
				int acrobatsUsed = Math.min(ac,actual1 - actual2);
				if(acrobatsUsed<0) continue;
				actual2+=acrobatsUsed;
				total2+=acrobatsUsed;
				total1+=ac-acrobatsUsed;
				//System.out.println(actual1+" "+actual2+" DAB2");
				int left = Math.min(none,n/2-total1);
				if(left<0) continue;
				total1+=left;
				total2+=none-left;
				//System.out.println(total1+" "+total2+" "+actual1+" "+ actual2);
				if(total1==total2&&total1==n/2&&actual1==actual2) {
					solved = true;
					for(int j = 0; j<left; j++)
						ans.add(a[0].pop());
					for(int j = 0; j<clownsUsed; j++)
						ans.add(a[1].pop());
					for(int j = 0; j<ac-acrobatsUsed; j++)
						ans.add(a[2].pop());
					for(int j = 0; j<bothAsClowns; j++)
						ans.add(a[3].pop());
				}
			}
		}
		if(solved) {
			for(Integer v : ans) System.out.print(v+" ");
		}else System.out.println(-1);
		
		
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