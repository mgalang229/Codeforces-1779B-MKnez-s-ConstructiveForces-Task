import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*

11


7


5
1 -2 1 -2 1 

a + b + c + d + e = x

a + b = x
x = a - x

b + c = x
(a - x) + c = x
c = 2x - a

c + d = x
(2x - a) + d = x
d = x - 2x + a
d = a - x

d + e = x
(a - x) + e = x
e = 2x - a

7
-4998 3332 -4998 3332 -4998 3332 -4998

7
3332 -4998 3332 -4998 3332 -4998 3332

5
1 -2 1 -2 1


 */

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			if (n == 3) {
				System.out.println("NO");
				continue;
			}
			int x = 0, y = 0;
			outer: for (int a = 1; a <= n / 2; a++) {
				for (int b = 1; b <= n / 2; b++) {
					if (a == 0 || b == 0) {
						continue;
					}
					int oddPos = n / 2;
					int evenPos = n / 2;
					if (n % 2 == 1) {
						oddPos++;
					}
					int tempA = a * -1, tempB = b;
					int sum1 = tempA * oddPos + tempB * evenPos;
					int sum2 = tempA * evenPos + tempB * oddPos;
					if (sum1 == tempA + tempB) {
						x = tempA;
						y = tempB;
//						System.out.println(x + " " + y);
						break outer;
					}
					if (sum2 == a + tempB) {
						x = tempB;
						y = tempA;
//						System.out.println(x + " " + y);
						break outer;
					}
					
					tempA = a;
					tempB = b * -1;
					sum1 = tempA * oddPos + tempB * evenPos;
					sum2 = tempA * evenPos + tempB * oddPos;
					if (sum1 == tempA + tempB) {
						x = tempA;
						y = tempB;
//						System.out.println(x + " " + y);
						break outer;
					}
					if (sum2 == a + tempB) {
						x = tempB;
						y = tempA;
//						System.out.println(x + " " + y);
						break outer;
					}
				}
			}
			System.out.println("YES");
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) {
					System.out.print(x + " ");
				} else {
					System.out.print(y + " ");
				}
			}
			System.out.println();
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	static void shuffleSortArr(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
