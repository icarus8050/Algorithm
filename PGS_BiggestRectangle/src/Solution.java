
public class Solution {

	public int solution(int [][]board)
    {
        int answer = 0;

        int[][] dp = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[i].length; j++)
        		dp[i + 1][j + 1] = board[i][j];
        }
        
        for (int i = 1; i < dp.length; i++) {
        	for (int j = 1; j < dp[i].length; j++) {
        		if (dp[i][j] != 1) continue;
        		
        		dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
        		answer = Math.max(answer, dp[i][j]);
        	}
        }
        return answer * answer;
    }
}
