/**
 * 66. Plus One (https://leetcode.com/problems/plus-one/)
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int idx = digits.length - 1;
        digits[idx]++;

        int carry = 0;
        while (idx >= 0) {
            digits[idx] += carry;
            carry = digits[idx] / 10;
            digits[idx] %= 10;
            idx--;
        }

        if (carry == 1) {
            int[] ans = new int[digits.length + 1];
            System.arraycopy(ans, 0, ans, 1, digits.length);
            ans[0] = 1;
            return ans;
        }

        return digits;
    }

    public int[] awesomeResolution(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
