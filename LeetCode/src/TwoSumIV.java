import java.util.HashSet;

/**
 * 653. Two Sum IV - Input is a BST
 * (https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/)
 */
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode current, int k, HashSet<Integer> set) {
        if (current == null) {
            return false;
        }
        if (set.contains(k - current.val)) {
            return true;
        }
        set.add(current.val);
        return dfs(current.left, k, set) || dfs(current.right, k, set);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
