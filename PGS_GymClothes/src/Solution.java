import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] a = {2, 3, 4};
		int[] b = {1, 2, 3};
		System.out.println(sol.solution(5, a, b));
	}
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] check = new int[n + 1];
        Arrays.fill(check, 1);
        
        for (int i = 0; i < lost.length; i++)
        	check[lost[i]]--;
        
        for (int i = 0; i < reserve.length; i++)
        	check[reserve[i]]++;
        
        for (int i = 0; i < check.length; i++) {
        	if (check[i] == 2){
        		if (i - 1 > 0 && check[i - 1] == 0){
        			check[i - 1]++;
        		} else if (i + 1 <= n && check[i + 1] == 0) {
        			check[i + 1]++;
        		}
        	}
        }
        for (int i = 1; i <= n; i++) {
        	if (check[i] > 0)
        		answer++;
        }
        
        return answer;
    }
}
