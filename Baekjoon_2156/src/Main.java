import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 2];
		int[] wine = new int[n + 2];
		
		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = wine[1];
		dp[2] = wine[1] + wine[2];
		
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]);
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}
		
		bw.write(dp[n] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
