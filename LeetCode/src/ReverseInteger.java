/**
 * Reverse Integer (https://leetcode.com/problems/reverse-integer/)
 */
public class ReverseInteger {
    public int reverse(int x) {
        String inputs = String.valueOf(x);
        StringBuilder sb;

        if (inputs.charAt(0) == '-') {
            sb = new StringBuilder(inputs.substring(1));
            sb.reverse();
            sb.insert(0, "-");
        } else {
            sb = new StringBuilder(inputs);
            sb.reverse();
        }

        int result;

        try {
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            result = 0;
        }

        return result;
    }
}
