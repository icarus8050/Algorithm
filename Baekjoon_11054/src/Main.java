import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] dp;
	static int[] reverse_dp;
	static int[] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int result = 1;
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N];
		reverse_dp = new int[N];
		A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			reverse_dp[i] = 1;
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j] && dp[i] <= dp[j])
					dp[i] = dp[j] + 1;
			}
		}
		
		for (int i = N - 1; i >= 0; i--) {
			for (int j = N - 1; j > i; j--) {
				if (A[i] > A[j] && reverse_dp[i] <= reverse_dp[j])
					reverse_dp[i] = reverse_dp[j] + 1;
			}
		}
		
		for (int i = 0; i < N; i++)
			result = Math.max(result, dp[i] + reverse_dp[i]);
		
		bw.write(result - 1 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
