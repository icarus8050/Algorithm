
public class Solution {

	boolean solution(String s) {
        int size = s.length();
        int cnt = 0;
        for (int i = 0; i < size; i++) {
        	if (s.charAt(i) == '(')
        		cnt++;
        	else {
        		if (cnt > 0)
        			cnt--;
        		else
        			return false;
        	}
        }
        if (cnt == 0)
        	return true;
        else
        	return false;
    }
}
