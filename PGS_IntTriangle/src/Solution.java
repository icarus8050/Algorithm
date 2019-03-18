
public class Solution {

	public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length + 1;
        int dp[][] = new int[N][N];
        
        dp[1][1] = triangle[0][0];
        for (int i = 2; i < triangle.length + 1; i++) {
        	for (int j = 1; j < triangle[i - 1].length + 1; j++)
        		dp[i][j] = triangle[i - 1][j - 1] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
        }
        
        for (int i = 1; i < N; i++)
        	answer = Math.max(answer, dp[N - 1][i]);
        return answer;
    }
}
