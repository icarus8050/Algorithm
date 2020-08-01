import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Generations of Tribbles (https://www.acmicpc.net/problem/9507)
 */
public class BOJ_9507 {

    static long[] dp = new long[68];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(koong(n) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static long koong(int n) {
        if (n < 2) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        if (dp[n] != 0) return dp[n];

        return dp[n] = koong(n - 1) + koong(n - 2) + koong(n - 3) + koong(n - 4);
    }
}
