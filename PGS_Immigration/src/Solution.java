
public class Solution {
	public long solution(int n, int[] times) {
        long max = 0;
        for (int time : times) {
        	if (max < time)
        		max = time;
        }
        
        long left = 1;
        long right = (long) max * n;
        
        while (left <= right) {
        	long mid = (left + right) / 2;
        	long total = 0;
        	
        	for (int time : times)
        		total += (mid / time);
        	
        	if (total >= n)
        		right = mid - 1;
        	else
        		left = mid + 1;
        }
        return left;
    }
}
