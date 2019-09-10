import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2579 {

    static int[] dp;
    static int[] stairs;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        stairs = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        if (n >= 2) {
            dp[2] = dp[1] + stairs[2];
        }

        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }

        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
