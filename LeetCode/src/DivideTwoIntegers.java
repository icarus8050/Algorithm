/**
 * 29. Divide Two Integers (https://leetcode.com/problems/divide-two-integers/)
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;

        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        long longAns = longDivide(longDividend, longDivisor);

        int ans;
        if (longAns > Integer.MAX_VALUE) {
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * longAns);
        }

        return ans;
    }

    private long longDivide(long dividend, long divisor) {
        if (dividend < divisor) return 0;

        long sum = divisor;
        long multiple = 1;
        while ((sum + sum) <= dividend) {
            sum += sum;
            multiple += multiple;
        }

        return multiple + longDivide(dividend - sum, divisor);
    }
}
