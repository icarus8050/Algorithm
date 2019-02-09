import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int box[];
		int dp[];
		Scanner sc = new Scanner(System.in);
		int box_count = sc.nextInt();
		
		box = new int[box_count];
		dp = new int[box_count];
		
		for(int i = 0; i < box.length; i++) {
			box[i] = sc.nextInt();
		}
		
		int ans = 0;
		
		for(int i = 0; i < box_count; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(box[i] > box[j] && dp[j] + 1 > dp[i])
					dp[i] = dp[j] + 1;
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
