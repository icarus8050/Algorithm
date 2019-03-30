
public class Solution {

	public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
        	sb.append("#");
        	sb.append(s.charAt(i));
        }
        sb.append("#");
        
        
        return manachers(sb, len * 2 + 1);
    }
	
	public int manachers(StringBuilder sb, int len) {
		int[] arr = new int[len];
		int r = 0;
		int p = 0;
		
		for (int i = 0; i < len; i++) {
			if (r >= i) {
				arr[i] = Math.min(arr[p * 2 - i], r - i);
			}
			
			while ((i - arr[i] - 1 >= 0) && (i + arr[i] + 1 < len)
					&& (sb.charAt(i - arr[i] - 1) == sb.charAt(i + arr[i] + 1))) {
				arr[i]++;
			}
			
			if (i + arr[i] > r) {
				r = i + arr[i];
				p = i;
			}
		}
		
		int ret = 0;
		for (int i = 0; i < len; i++) {
			ret = Math.max(ret, arr[i]);
		}
		
		return ret;
	}
	
}
