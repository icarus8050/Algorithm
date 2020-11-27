/**
 * 67. Add Binary (https://leetcode.com/problems/add-binary/)
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (a.length() >= b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        int shortIdx = a.length() - 1;
        int longIdx = b.length() - 1;

        int carry = 0;
        while (shortIdx >= 0 && longIdx >= 0) {
            int aVal = a.charAt(shortIdx--) - '0';
            int bVal = b.charAt(longIdx--) - '0';
            int c = aVal + bVal + carry;
            carry = c / 2;
            c %= 2;
            sb.insert(0, c);
        }

        while (longIdx >= 0) {
            int val = b.charAt(longIdx--) - '0';
            int c = val + carry;
            carry = c / 2;
            c %= 2;
            sb.insert(0, c);
        }

        if (carry != 0) {
            sb.insert(0, 1);
        }

        return sb.toString();
    }
}
