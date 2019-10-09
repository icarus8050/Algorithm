import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1463 {

    static int N;
    static int[] dp;
    static final int INF = 100_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        for (int i = 2; i < N + 1; i++) {
            dp[i] = INF;
        }

        for (int i = 2; i < N + 1; i++) {
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
