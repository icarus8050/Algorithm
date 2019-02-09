import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] A;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int maxValue = 1;
		
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
					maxValue = Math.max(maxValue, dp[i]);
				}
			}
		}
		
		bw.write(maxValue + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
