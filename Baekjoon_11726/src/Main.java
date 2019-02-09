import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		bw.write(solve(n) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int solve(int n) {
		if (dp[n] > 0) 
			return dp[n];
		
		if (n < 2)
			return dp[n] = 1;
		
		else
			return dp[n] = (solve(n - 1) + solve(n - 2)) % 10007;
	}
}
