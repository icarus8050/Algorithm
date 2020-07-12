/**
 * ZigZag Conversion (https://leetcode.com/problems/zigzag-conversion/)
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuffer[] rowsBuf = new StringBuffer[numRows];
        int len = s.length();

        for (int i = 0; i < numRows; i++) {
            rowsBuf[i] = new StringBuffer();
        }

        int idx = 0;
        while (idx < len) {
            for (int i = 0; i < numRows && idx < len; i++) {
                rowsBuf[i].append(s.charAt(idx++));
            }

            for (int i = numRows - 2; i > 0 && idx < len; i--) {
                rowsBuf[i].append(s.charAt(idx++));
            }
        }

        for (int i = 1; i < numRows; i++) {
            rowsBuf[0].append(rowsBuf[i]);
        }

        return rowsBuf[0].toString();
    }
}
