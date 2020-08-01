import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 동전 2 (https://www.acmicpc.net/problem/2294)
 */
public class BOJ_2294 {
    static int INF = 100_001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 1, k + 1, INF);

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        if (dp[k] == INF) bw.write("-1\n");
        else bw.write(dp[k] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
