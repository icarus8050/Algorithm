import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses (https://leetcode.com/problems/generate-parentheses/)
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve(res, "", 0, 0, n);
        return res;
    }

    private void solve(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max) {
            solve(list, str + "(", open + 1, close, max);
        }

        if (close < open) {
            solve(list, str + ")", open, close + 1, max);
        }
    }
}
