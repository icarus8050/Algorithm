/**
 * 14. Longest Common Prefix (https://leetcode.com/problems/longest-common-prefix/)
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); sb.append(strs[0].charAt(i++))) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i))
                    return sb.toString();
            }
        }

        return sb.toString();
    }
}
