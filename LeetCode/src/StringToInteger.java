import java.math.BigInteger;

/**
 * 8. String to Integer (atoi) (https://leetcode.com/problems/string-to-integer-atoi/)
 */
public class StringToInteger {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        boolean isPlus = true;
        char sign = str.charAt(0);
        if (!(sign >= '0' && sign <= '9') && (sign != '-' && sign != '+')) {
            return 0;
        } else if (sign == '-') {
            isPlus = false;
            str = str.substring(1);
        } else if (sign == '+') {
            str = str.substring(1);
        }

        int len = str.length();
        int endIdx = 0;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(endIdx);
            if (!(ch >= '0' && ch <= '9')) break;

            endIdx++;
        }

        str = str.substring(0, endIdx);
        if (str.length() == 0) return 0;
        BigInteger num = new BigInteger(str);
        if (isPlus) {
            BigInteger max = new BigInteger(String.valueOf(Integer.MAX_VALUE));
            if (num.compareTo(max) >= 0) return Integer.MAX_VALUE;

        } else {
            num = num.negate();
            BigInteger min = new BigInteger(String.valueOf(Integer.MIN_VALUE));
            if (num.compareTo(min) < 0) return Integer.MIN_VALUE;
        }

        return num.intValue();
    }
}
