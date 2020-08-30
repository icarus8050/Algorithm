import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number (https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
 */
public class LetterCombinationsOfAPhoneNumber {
    public static String[] phone = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits != null && digits.length() != 0) dfs(0, "", digits, result);
        return result;
    }

    private void dfs(int count, String str, String digits, List<String> result) {
        if (count >= digits.length()) {
            result.add(str);
            return;
        }

        String letters = phone[digits.charAt(count) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            dfs(count + 1, str + letters.charAt(i), digits, result);
        }
    }

    public List<String> letterCombinations_2(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits == null || digits.isEmpty()) return ans;

        String[] maps = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = maps[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }

        return ans;
    }
}
