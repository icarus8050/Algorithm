import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 격자상의 경로 (https://www.acmicpc.net/problem/10164)
 */
public class BOJ_10164 {

    static int n, m, k;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        dp = new int[n + 1][m + 1];

        if (k == 0) {
            bw.write(solve(1, 1, n, m) + "\n");
        } else {
            int k_n = (k - 1) / m + 1;
            int k_m = (k - 1) % m + 1;
            bw.write((solve(1, 1, k_n, k_m) * solve(k_n, k_m, n, m)) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int s_n, int s_m, int e_n, int e_m) {
        dp[s_n - 1][s_m] = 0;
        dp[s_n][s_m - 1] = 0;
        dp[s_n][s_m] = 1;

        for (int i = s_n; i <= e_n; i++) {
            for (int j = s_m; j <= e_m; j++) {
                dp[i][j] += (dp[i - 1][j] + dp[i][j - 1]);
            }
        }

        return dp[e_n][e_m];
    }
}
