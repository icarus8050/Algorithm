import java.util.Scanner;

/**
 * 합분해 (https://www.acmicpc.net/problem/2225)
 */
public class BOJ_2225 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long[][] dp = new long[k + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] += dp[i - 1][j - l] % 1000000000;
                }
            }
        }

        System.out.println(dp[k][n] % 1000000000);
        sc.close();
    }
}
