import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		dp = new int[21][21][21];
		for (int[][] a : dp) {
			for (int[] b : a)
				Arrays.fill(b, -1);
		}
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == -1 && b == -1 && c == -1)
				break;
			
			bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
	public static int w(int a, int b, int c) {
		if (inRange(a, b, c) && dp[a][b][c] != -1)
			return dp[a][b][c];
		
		else if (a <= 0 || b <= 0 || c <= 0)
			return 1;
		
		else if (a > 20 || b > 20 || c > 20)
			return dp[20][20][20] = w(20, 20, 20);
		
		else
			return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}
	public static boolean inRange(int a, int b, int c) {
		return (a >= 0 && a <= 20) && (b >= 0 && b <= 20) && (c >= 0 && c <= 20);
	}
}
