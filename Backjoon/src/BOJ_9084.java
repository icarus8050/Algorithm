import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 동전 (https://www.acmicpc.net/problem/9084)
 */
public class BOJ_9084 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];

            String[] c = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(c[i]);
            }

            int money = Integer.parseInt(br.readLine());
            int[] dp = new int[money + 1];
            dp[0] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = coins[i]; j <= money; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }

            bw.write(dp[money] + "\n");
        }



        bw.flush();
        bw.close();
        br.close();
    }
}
