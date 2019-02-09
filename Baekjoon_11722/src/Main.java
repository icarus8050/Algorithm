import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] dp;
	static int[] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int result = 1;
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N];
		A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] < A[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
					result = Math.max(result, dp[i]);
				}
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
