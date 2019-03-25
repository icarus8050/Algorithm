
public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] arr = {120, 110, 140, 150};
		System.out.println(sol.solution(arr, 485));
	}
	public int solution(int[] budgets, int M) {
        int max = 0;
        
        for (int money: budgets) {
        	max = Math.max(max, money);
        }
        
        int low = 1, high = max;
        while (low <= high) {
        	int mid = (low + high) / 2;
        	int sum = 0;
        	
        	for (int money: budgets) {
        		if (mid > money) {
        			sum += money;
        		} else {
        			sum += mid;
        		}
        	}
        	
        	if (sum > M) {
    			high = mid - 1;
    		} else {
    			low = mid + 1;
    		}
        }
        
        return high;
    }
}
