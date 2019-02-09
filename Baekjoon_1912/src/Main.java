import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] dp;
	static int[] s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int result;
		
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n];
		s = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			s[i] = Integer.parseInt(st.nextToken());
		
		dp[0] = s[0];
		for (int i = 1; i < n; i ++) {
			if (dp[i - 1] + s[i] > s[i])
				dp[i] = dp[i - 1] + s[i];
			else
				dp[i] = s[i];
		}
		
		result = dp[0];
		for (int i = 1; i < n; i++) {
			result = Math.max(result, dp[i]);
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
