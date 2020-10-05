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

    /**
     * 더 간결한 O(n) 복잡도 코드
     */
    public int maxSubArray_2(int[] nums) {
        int max = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            end = Math.max(end + nums[i], nums[i]);
            max = Math.max(max, end);
        }
        return max;
    }
}
