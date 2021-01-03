import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Random;
/*
    Solution Created: 23:31:09 12/06/2019
    Custom Competitive programming helper.
*/

public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		Word[] words = new Word[n];
		for (int i = 0; i < n; i++)
			words[i] = new Word(in.next());
		Arrays.sort(words);
		ArrayList<Sentence> part1 = new ArrayList<>();
		ArrayList<Sentence> part2 = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			if (words[i] == null)
				continue;
			if (words[i].lastVowel == words[i + 1].lastVowel && words[i].vowels == words[i + 1].vowels) {
				part2.add(new Sentence(words[i], words[i + 1]));
				words[i] = null;
				words[i + 1] = null;
			}
		}
		int idx = 0;
		boolean cont = true;
		for (int i = 0; i < n && cont; i++) {
			if (words[i] == null) continue;
			idx = Math.max(idx, i + 1);
			while (idx < n && words[idx] == null) idx++;
			if (idx == n) {
				cont = false;
			} else if (words[i].vowels == words[idx].vowels) {
				part1.add(new Sentence(words[i], words[idx]));
				words[i] = null;
				words[idx] = null;
			}
		}
		ArrayList<Final> ans = new ArrayList<>();
		int m = Math.min(part1.size(), part2.size());
		for(int i = 0; i<m; i++) ans.add(new Final(part1.get(i), part2.get(i)));
		for(int i = m; i<part2.size(); i+=2) if(i+1<part2.size()) ans.add(new Final(part2.get(i), part2.get(i+1)));
		System.out.println(ans.size());
		for(Final f : ans)  f.print();
	}

	static class Final {
		Sentence s1, s2;

		public Final(Sentence s1, Sentence s2) {
			this.s1 = s1;
			this.s2 = s2;
		}

		public void print() {
			System.out.println(s1.w1.word + " " + s2.w1.word);
			System.out.println(s1.w2.word + " " + s2.w2.word);
		}
	}

	static class Sentence {
		Word w1, w2;
		int vowels;
		char lastVowel;

		public Sentence(Word w1, Word w2) {
			this.w1 = w1;
			this.w2 = w2;
			this.vowels = w1.vowels;
			this.lastVowel = w2.lastVowel;
		}
	}

	static class Word implements Comparable<Word> {
		int vowels;
		char lastVowel;
		String word;

		public Word(String s) {
			this.word = s;
			this.vowels = 0;
			this.lastVowel = 'x';
			for (int i = s.length() - 1; i >= 0; i--) {
				if (isVowel(s.charAt(i))) {
					this.vowels++;
					if (lastVowel == 'x')
						this.lastVowel = s.charAt(i);
				}
			}
		}

		@Override
		public int compareTo(Word o) {
			if (this.vowels == o.vowels)
				return this.lastVowel - o.lastVowel;
			return this.vowels - o.vowels;
		}
	}

	static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		return false;
	}

static class Graph {
	private ArrayList<Integer> con[];
	private boolean[] visited;
	public boolean[] good;
	public boolean[] chosen;
	int ch = 0;
	public Graph(int n) {
		con = new ArrayList[n];
		for (int i = 0; i < n; ++i)
			con[i] = new ArrayList();
		visited = new boolean[n];
		good = new boolean[n];
		chosen = new boolean[n];
	}

	public void reset() {
		Arrays.fill(visited, false);
	}

	public void addEdge(int v, int w) {
		con[v].add(w);
	}

	public void dfs(int cur) {
		if(visited[cur]) return;
		visited[cur] = true;
		for (Integer v : con[cur]) {
			if (!visited[v]) {
				dfs(v);
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
		public static int upperBound(int[] a, int v) {
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
		public static int lowerBound(int[] a, int v) {
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
		public static void dbg(Object... o) { System.out.println(Arrays.deepToString(o)); }
	}
}