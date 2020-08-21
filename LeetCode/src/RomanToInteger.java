/**
 * 13. Roman to Integer (https://leetcode.com/problems/roman-to-integer/)
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int sum = 0;
        if (s.contains("IV")) sum -= 2;
        if (s.contains("IX")) sum -= 2;
        if (s.contains("XL")) sum -= 20;
        if (s.contains("XC")) sum -= 20;
        if (s.contains("CD")) sum -= 200;
        if (s.contains("CM")) sum -= 200;

        char[] c = s.toCharArray();

        for (char value : c) {
            if (value == 'I') sum += 1;
            else if (value == 'V') sum += 5;
            else if (value == 'X') sum += 10;
            else if (value == 'L') sum += 50;
            else if (value == 'C') sum += 100;
            else if (value == 'D') sum += 500;
            else if (value == 'M') sum += 1000;
        }

        return sum;
    }
}
