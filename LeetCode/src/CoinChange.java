/**
 * 322. Coin Change (https://leetcode.com/problems/coin-change/description/)
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 1; i < amount + 1; i++) {
            dp[0][i] = INF;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][amount] != INF ? dp[n][amount] : -1;
    }

    private final static int INF = Integer.MAX_VALUE - 1;
}
