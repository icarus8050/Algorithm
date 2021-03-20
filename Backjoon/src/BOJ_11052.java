import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 카드 구매하기 (https://www.acmicpc.net/problem/11052)
 */
public class BOJ_11052 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n + 1];
        int[] dp = new int[n + 1];

        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            cards[i] = Integer.parseInt(input[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cards[j]);
            }
        }

        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
