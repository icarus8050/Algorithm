import java.util.HashSet;

/**
 * 2441. Largest Positive Integer That Exists With Its Negative
 * (https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/)
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int largestPositiveInteger = -1;
        for (int num : nums) {
            if (set.contains(-num)) {
                largestPositiveInteger = Math.max(largestPositiveInteger, Math.abs(num));
            }
            set.add(num);
        }
        return largestPositiveInteger;
    }
}
