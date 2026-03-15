/**
 * 520. Detect Capital (https://leetcode.com/problems/detect-capital/description/)
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int capitalCnt = 0;

        for (int i = 0; i < word.length(); i++) {
            if (isCapital(word.charAt(i))) {
                capitalCnt++;
            }
        }

        return word.length() == capitalCnt || capitalCnt == 0 || (capitalCnt == 1 && isCapital(word.charAt(0)));
    }

    private boolean isCapital(char ch) {
        return ch >= 65 && ch <= 90;
    }
}
