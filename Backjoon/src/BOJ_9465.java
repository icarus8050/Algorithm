import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 스티커 (https://www.acmicpc.net/problem/9465)
 */
public class BOJ_9465 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n + 1];
            int[][] sticker = new int[2][n + 1];

            String[] s = br.readLine().split(" ");
            for (int i = 1; i < n + 1; i++) {
                sticker[0][i] = Integer.parseInt(s[i - 1]);
            }

            s = br.readLine().split(" ");
            for (int i = 1; i < n + 1; i++) {
                sticker[1][i] = Integer.parseInt(s[i - 1]);
            }

            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for (int i = 2; i < n + 1; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }

            bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
