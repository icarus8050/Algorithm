import java.util.Scanner;

public class BOJ_2748 {

    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        dp = new long[num + 1];

        System.out.println(fibonacci(num));
        sc.close();
    }

    public static long fibonacci(int n) {
        if (n == 0) return 0L;
        if (n == 1) return dp[1] = 1L;

        if (dp[n] == 0) dp[n] = fibonacci(n - 1) + fibonacci(n - 2);

        return dp[n];
    }
}
