
public class Solution {

	static int[][] dp;
	static int N;
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] arr = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
		System.out.println(sol.solution(arr));
	}
	int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        for (int i = 1; i < N; i++) {
        	land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
        	land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
        	land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
        	land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        
        for (int i = 0; i < 4; i++)
        	answer = Math.max(answer, land[N - 1][i]);
        return answer;
    }
	/*int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        dp = new int[N][4];
        for (int i = 0; i < 4; i++)
        	dp[0][i] = land[0][i];
        
        solve(1, land);
        for (int i = 0; i < 4; i++)
        	answer = Math.max(answer, dp[N - 1][i]);
        return answer;
    }
	
	public void solve(int row, int[][] land) {
		if (row == N)
			return;
		int max = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i == j)
					continue;
				max = Math.max(max, dp[row - 1][j]);
			}
			dp[row][i] = max + land[row][i];
			max = 0;
		}
		solve(row + 1, land);
	}*/
}
