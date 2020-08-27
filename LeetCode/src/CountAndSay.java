/**
 * 38. Count and Say (https://leetcode.com/problems/count-and-say/)
 */
public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder current = new StringBuilder("1");
        StringBuilder prev;

        int count;
        char say;

        for (int i = 1; i < n; i++) {
            prev = current;
            current = new StringBuilder();
            count = 1;
            say = prev.charAt(0);

            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) != say) {
                    current.append(count).append(say);
                    say = prev.charAt(j);
                    count = 1;
                } else {
                    count++;
                }
            }
            current.append(count).append(say);
        }

        return current.toString();
    }
}
