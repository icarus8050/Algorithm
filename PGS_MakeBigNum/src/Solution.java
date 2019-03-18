
public class Solution {

	public static void main(String[] args) {
		String num = "1924";
		System.out.println(solution(num, 2));
	}
	public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        while (k-- > 0) {
        	int size = sb.length();
        	for (int i = 0; i < size; i++) {
        		if (i != size - 1) {
        			if (sb.charAt(i + 1)> sb.charAt(i)) {
        				sb.deleteCharAt(i);
        				break;
        			}
        		}
        		else
        			sb.deleteCharAt(i);
        	}
        }
        return sb.toString();
    }
}
