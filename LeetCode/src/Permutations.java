import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations (https://leetcode.com/problems/permutations/)
 */
public class Permutations {
    private static boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        visited = new boolean[nums.length];
        backtracking(ans, new ArrayList<>(), nums);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            ans.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    tempList.add(nums[i]);
                    backtracking(ans, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}
