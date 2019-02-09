import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int[] dp;
	static int[] S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int result;
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		S = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(br.readLine());
			dp[i] = 1;
		}
		
		result = dp[1];
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (S[i] > S[j] && dp[j] >= dp[i]) {
					dp[i] = dp[j] + 1;
					result = Math.max(result, dp[i]);
				}
			}
		}
		
		bw.write((N - result) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
