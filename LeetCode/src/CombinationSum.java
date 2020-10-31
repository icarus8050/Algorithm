import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum (https://leetcode.com/problems/combination-sum/)
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans, new ArrayList<>(), 0, candidates, target);
        return ans;
    }

    public void solve(List<List<Integer>> ans,
                      List<Integer> temp,
                      int idx,
                      int[] candidates,
                      int target) {
        if (target < 0) return;
        else if (target == 0) ans.add(new ArrayList<>(temp));
        else {
            for (int i = idx; i < candidates.length; i++) {
                temp.add(candidates[i]);
                solve(ans, temp, i, candidates, target - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
