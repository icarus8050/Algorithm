import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] arrA, arrB;
	static int[][] dp;
	static int n, m;
	static int MIN = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arrA = new int[n + 1];
			arrB = new int[m + 1];
			dp = new int[n + 1][m + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++)
				arrA[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++)
				arrB[i] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i <= n; i++)
				for (int j = 0; j <= m; j++)
					dp[i][j] = -1;
			
			bw.write(JLIS(0, 0) + "\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
	
	public static int JLIS(int indexA, int indexB) {
		if (dp[indexA][indexB] != -1)
			return dp[indexA][indexB];
		
		dp[indexA][indexB] = 0;
		
		int a = (indexA == 0 ? MIN : arrA[indexA]);
		int b = (indexB == 0 ? MIN : arrB[indexB]);
		int maxElement = Math.max(a, b);
		
		for (int nextA = indexA + 1; nextA <= n; nextA++)
			if (arrA[nextA] > maxElement)
				dp[indexA][indexB] = Math.max(dp[indexA][indexB], JLIS(nextA, indexB) + 1);
		
		for (int nextB = indexB + 1; nextB <= m; nextB++) 
			if (arrB[nextB] > maxElement)
				dp[indexA][indexB] = Math.max(dp[indexA][indexB], JLIS(indexA, nextB) + 1);
		
		return dp[indexA][indexB];
	}
}