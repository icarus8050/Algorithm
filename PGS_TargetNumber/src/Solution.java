
public class Solution {
	
	static int N;
	static int[] arr;
	public int solution(int[] numbers, int target) {
        int answer = 0;
        N = numbers.length;
        arr = numbers;
        answer = dfs(0, 0, target);
        return answer;
    }
	
	public int dfs(int num, int cnt, int target) {
		if (cnt == N) {
			if (num == target)
				return 1;
			return 0;
		}
		
		int res = 0;
		res += dfs(num + arr[cnt], cnt + 1, target);
		res += dfs(num - arr[cnt], cnt + 1, target);
		
		return res;
	}
}
