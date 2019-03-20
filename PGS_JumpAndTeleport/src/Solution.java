
public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(5000));
	}
	public int solution(int n) {
        return solve(n);
    }
	
	public int solve(int n) {
		if (n == 1)
			return 1;
		
		if (n % 2 == 0)
			return solve(n / 2);
		else
			return solve(n - 1) + 1;
	}
}
