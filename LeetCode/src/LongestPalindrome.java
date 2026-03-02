import java.util.HashSet;

/**
 * 409. Longest Palindrome (https://leetcode.com/problems/longest-palindrome/description/)
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (set.contains(ch)) {
                result += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        return set.size() >= 1 ? result + 1 : result;
    }
}
