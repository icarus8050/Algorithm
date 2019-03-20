
public class Solution {

	static boolean[] prime = new boolean[50001];
	static int[] arr;
	static boolean[] visited;
	public int solution(int[] nums) {
        
        for (int i = 2; i * i <= 50000; i++) {
        	for (int j = i * i; j <= 50000; j += i) {
        		if (prime[j] == false)
        			prime[j] = true;
        	}
        }
        arr = nums;
        visited = new boolean[nums.length];
        return dfs(0, 0, 0);
    }
	
	public int dfs(int n, int sum, int cnt) {
		if (cnt == 3) {
			if (!prime[sum]) return 1;
			else return 0;
		}
		int res = 0;
		for (int i = n; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				res += dfs(i, sum + arr[i], cnt + 1);
				visited[i] = false;
			}
		}
		return res;
	}
}
