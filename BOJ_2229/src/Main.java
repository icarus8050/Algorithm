import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		Arrays.fill(dp, -1);
		int ans = solve(0);
		System.out.println(ans);
		br.close();
	}
	
	public static int solve(int num) {
		if (num == N)
			return 0;
		
		if (dp[num] != -1)
			return dp[num];
		
		dp[num] = 0;
		int high = 0;
		int low = Integer.MAX_VALUE;
		for (int i = num; i < N; i++) {
			high = Math.max(high, arr[i]);
			low = Math.min(low, arr[i]);
			dp[num] = Math.max(dp[num], (high - low) + solve(i + 1));
		}
		return dp[num];
	}
}
