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
		int maxValue = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			dp[i] = A[i];
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j] && dp[i] < dp[j] + A[i]) {
					dp[i] = dp[j] + A[i];
				}
			}
			maxValue = Math.max(maxValue, dp[i]);
		}
		
		bw.write(maxValue + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
