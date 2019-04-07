import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] V;
	static int N, S, M;
	static int max = 0;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = new int[N];
		dp = new int[M + 1][N];
		
		for (int[] d : dp)
			Arrays.fill(d, -2);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dfs(S, 0));
		br.close();
	}
	
	public static int dfs(int num, int cnt) {
		if (num < 0 || num > M) return -1;
		if (cnt == N) return num;
		
		if (dp[num][cnt] != -2)
			return dp[num][cnt];
		
		return dp[num][cnt] = Math.max(dfs(num + V[cnt], cnt + 1), dfs(num - V[cnt], cnt + 1));
	}
}
