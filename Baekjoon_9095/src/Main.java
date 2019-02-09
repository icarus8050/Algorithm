import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		while (T > 0) {
			int n = Integer.parseInt(br.readLine());
			dp = new int[n + 1];
			bw.write(solve(n) + "\n");
			bw.flush();
			T--;
		}
		br.close();
		bw.close();
	}
	
	public static int solve(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		
		if (dp[n] > 0)
			return dp[n];
		return (solve(n - 1) + solve(n - 2) + solve(n - 3));
	}
}
