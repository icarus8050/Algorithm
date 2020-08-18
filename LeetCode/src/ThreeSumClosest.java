import java.util.Arrays;

/**
 * 6. 3Sum Closest (https://leetcode.com/problems/3sum-closest/)
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;

            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(result - target) > Math.abs(sum - target))
                    result = sum;

                if (sum > target) hi--;
                else lo++;
            }
        }

        return result;
    }
}
