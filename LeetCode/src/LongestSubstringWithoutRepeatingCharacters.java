import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters (https://leetcode.com/problems/longest-substring-without-repeating-characters/)
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int length = s.length();
        int left = 0;
        int right = 0;
        int ans = 0;

        while (right < length) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                ans = Math.max(ans, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return ans;
    }
}
