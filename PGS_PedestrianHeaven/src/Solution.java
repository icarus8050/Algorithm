
public class Solution {

	int MOD = 20170805;

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] arr = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
		System.out.println(sol.solution(3, 6, arr));
	}
	
	public int solution(int m, int n, int[][] cityMap) {
		
		int[][] left = new int[m + 1][n + 1];
		int[][] upper = new int[m + 1][n + 1];
		
		left[1][1] = 1;
		upper[1][1] = 1;
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (cityMap[i - 1][j - 1] == 0) {
					left[i][j] += (left[i][j - 1] + upper[i - 1][j]) % MOD;
					upper[i][j] += (left[i][j - 1] + upper[i - 1][j]) % MOD;
				} else if (cityMap[i - 1][j - 1] == 1) {
					left[i][j] = 0;
					upper[i][j] = 0;
				} else {
					left[i][j] = left[i][j - 1];
					upper[i][j] = upper[i - 1][j];
				}
			}
		}
		
		return (left[m][n - 1] + upper[m - 1][n]) % MOD;
	}
}
