import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] dp = new int[41];
		int[] seat = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		
		int result = 1;
		int start = 1;
		for (int i = 0; i < M; i++) {
			int vip = Integer.parseInt(br.readLine());
			result *= dp[vip - start];
			start = vip + 1;
		}
		if (start < N + 1)
			result *= dp[N + 1 - start];
		System.out.println(result);
		br.close();
	}
}
