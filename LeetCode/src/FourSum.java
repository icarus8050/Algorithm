import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum (https://leetcode.com/problems/4sum/)
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;

        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        getFourSum(nums, target, 0, ans, list, 0);
        return ans;
    }

    private void getFourSum(int[] nums,
                            int target,
                            int sum,
                            List<List<Integer>> ans,
                            List<Integer> list,
                            int idx) {
        if (list.size() == 4 && sum == target && !ans.contains(list)) {
            ans.add(new ArrayList<>(list));
            return;
        } else if (list.size() == 4) return;

        for (int i = idx; i < nums.length; i++) {
            if (nums[i] + nums[nums.length - 1] * (3 - list.size()) + sum < target) continue;
            if (nums[i] * (4 - list.size()) + sum > target) return;
            list.add(nums[i]);
            getFourSum(nums, target, sum + nums[i], ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
