import java.util.Scanner;

/**
 * 01타일 (https://www.acmicpc.net/problem/1904)
 */
public class BOJ_1904 {

    static int N;
    static int[] dp;
    static final int MOD = 15_746;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N + 1];

        if (N == 1) {
            System.out.println(1);
        } else if (N == 2) {
            System.out.println(2);
        } else {
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i < N + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }

            System.out.println(dp[N]);
        }
        sc.close();
    }
}
