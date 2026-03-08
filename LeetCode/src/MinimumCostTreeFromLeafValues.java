import java.util.Arrays;

/**
 * 1130. Minimum Cost Tree From Leaf Values (https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/)
 */
public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(arr, 0, arr.length - 1, dp);
    }

    private int solve(int[] arr, int left, int right, int[][] dp) {
        if (left == right) {
            return dp[left][right] = 0;
        }

        if (left + 1 == right) {
            return dp[left][right] = arr[left] * arr[right];
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = left; i < right; i++) {
            int max1 = findMax(arr, left, i);
            int max2 = findMax(arr, i + 1, right);
            int temp = solve(arr, left, i, dp) + solve(arr, i + 1, right, dp);
            ans = Math.min(ans, (max1 * max2) + temp);
        }
        return dp[left][right] = ans;
    }

    private int findMax(int[] arr, int left, int right) {
        int max = 0;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
