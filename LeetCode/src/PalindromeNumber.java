/**
 * 9. Palindrome Number (https://leetcode.com/problems/palindrome-number/submissions/)
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x < 10) return true;

        char[] input = Integer.toString(x).toCharArray();

        int size = input.length;
        for (int i = 0; i < size / 2; i++) {
            if (input[i] != input[size - i - 1]) return false;
        }

        return true;
    }
}
