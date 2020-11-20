import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations 2 (https://leetcode.com/problems/permutations-ii/)
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        solve(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    private void solve(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] visited) {
        if (nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            solve(ans, temp, nums, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
