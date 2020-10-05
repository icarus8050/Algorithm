/**
 * 53. Maximum Subarray (https://leetcode.com/problems/maximum-subarray/)
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < len; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
