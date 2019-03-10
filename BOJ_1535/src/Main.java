import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] dp;
	static int[] guest;
	static int[] happy;
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[101][N];
		guest = new int[N];
		happy = new int[N];
		
		for (int[] arr : dp)
			Arrays.fill(arr, -1);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			guest[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			happy[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(solve(100, 0));
		br.close();
	}
	
	public static int solve(int health, int num) {
		if (num == N)
			return 0;
		
		if (dp[health][num] != -1)
			return dp[health][num];
		
		dp[health][num] = solve(health, num + 1);
		if (health - guest[num] > 0) {
			dp[health][num] = Math.max(dp[health][num], solve(health - guest[num], num + 1) + happy[num]);
		}
		return dp[health][num];
	}
}
