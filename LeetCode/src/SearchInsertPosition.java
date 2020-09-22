/**
 * 35. Search Insert Position (https://leetcode.com/problems/search-insert-position/)
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int idx = 0;

        for (int num : nums) {
            if (num >= target) {
                break;
            }
            idx++;
        }

        return idx;
    }
}
