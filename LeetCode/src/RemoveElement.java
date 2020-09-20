/**
 * 27. Remove Element (https://leetcode.com/problems/remove-element/)
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            }
        }

        return idx;
    }
}
