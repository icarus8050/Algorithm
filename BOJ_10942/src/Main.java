import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] dp;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		dp = new boolean[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			dp[i][i] = true;
			if (arr[i] == arr[i - 1])
				dp[i - 1][i] = true;
		}
		
		for (int i = 2; i < N; i++) {
			for (int j = 1; j <= N - i; j++) {
				if ((arr[j] == arr[j + i]) && dp[j + 1][j + i - 1])
					dp[j][j + i] = true;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (dp[a][b])
				bw.write(1 + "\n");
			else
				bw.write(0 + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
