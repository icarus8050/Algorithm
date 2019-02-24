import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N + 1][3];
		int[][] dp = new int[N + 1][3];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				house[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + house[i][2];
		}
		int result = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
