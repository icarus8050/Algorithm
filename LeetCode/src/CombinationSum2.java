import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum 2 (https://leetcode.com/problems/combination-sum-ii/)
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans, new ArrayList<>(), 0, candidates, target);
        return ans;
    }

    private void solve(List<List<Integer>> ans,
                       List<Integer> temp,
                       int idx,
                       int[] candidates,
                       int target) {
        if (target < 0) return;
        else if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            solve(ans, temp, i + 1, candidates, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
