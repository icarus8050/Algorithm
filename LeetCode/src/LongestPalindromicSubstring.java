/**
 * Longest Palindromic Substring (https://leetcode.com/problems/longest-palindromic-substring/)
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    public String longestPalindromeForManacher(String s) {
        char[] newStr = new char[s.length() * 2 + 1];
        newStr[0] = '#';
        for (int i = 0; i < s.length(); i++) {
            newStr[2 * i + 1] = s.charAt(i);
            newStr[2 * i + 2] = '#';
        }
        int[] dp = new int[newStr.length];
        int friendCenter = 0, friendRadius = 0, lpsCenter = 0, lpsRadius = 0;
        for (int i = 0; i < newStr.length; i++) {
            dp[i] = friendCenter + friendRadius > i ? Math.min(dp[friendCenter * 2 - i], (friendCenter + friendRadius) - i) : 1;
            while (i + dp[i] < newStr.length && i - dp[i] >= 0 && newStr[i + dp[i]] == newStr[i - dp[i]]) dp[i]++;
            if (friendCenter + friendRadius < i + dp[i]) {
                friendCenter = i;
                friendRadius = dp[i];
            }
            if (lpsRadius < dp[i]) {
                lpsCenter = i;
                lpsRadius = dp[i];
            }
        }
        return s.substring((lpsCenter - lpsRadius + 1) / 2, (lpsCenter + lpsRadius - 1) / 2);
    }

    public String longestPalindrome2(String s) {
        char[] sharpString = new char[s.length() * 2 + 1];
        sharpString[0] = '#';
        for (int i = 0; i < s.length(); i++) {
            sharpString[i * 2 + 1] = s.charAt(i);
            sharpString[i * 2 + 2] = '#';
        }

        int[] dp = new int[sharpString.length];
        int palCenter = 0, palRadius = 0;
        int resCenter = 0, resRadius = 0;

        int size = sharpString.length;
        for (int i = 0; i < size; i++) {
            dp[i] = palCenter + palRadius > i ?
                    Math.min(dp[palCenter * 2 - i], (palCenter + palRadius) - i)
                    : 1;

            while (i + dp[i] < size
                    && i - dp[i] >= 0
                    && sharpString[i + dp[i]] == sharpString[i - dp[i]]) {
                dp[i]++;
            }

            if (palCenter + palRadius < i + dp[i]) {
                palCenter = i;
                palRadius = dp[i];
            }

            if (resRadius < dp[i]) {
                resCenter = i;
                resRadius = dp[i];
            }
        }

        return s.substring((resCenter - resRadius + 1) / 2, (resCenter + resRadius - 1) / 2);
    }
}
