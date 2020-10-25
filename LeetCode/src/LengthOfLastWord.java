/**
 * 58. Length of Last Word (https://leetcode.com/problems/length-of-last-word/)
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}
