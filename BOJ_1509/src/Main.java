import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static boolean[][] isPalindrome;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int len = str.length();
		isPalindrome = new boolean[len][len];
		dp = new int[len];
		Arrays.fill(dp, -1);
		
		for (int i = 0; i < len; i++) {
			isPalindrome[i][i] = true;
			for (int j = 0; j < i; j++) {
				if (str.charAt(i) == str.charAt(j))
					isPalindrome[j][i] = isPalindrome[j - 1][i + 1];
				
				//Â¦¼öÀÎ °æ¿ì
				if (i - j == 1)	
					isPalindrome[j][i] |= (str.charAt(i) == str.charAt(i - 1));
			}
		}
		
		sc.close();
	}
}
