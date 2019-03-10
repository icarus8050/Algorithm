import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		String[] word = new String[N];
		
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
			int len = word[i].length();
			
			for (int j = 0; j < len; j++)
				alpha[word[i].charAt(j) - 'A'] += (int) Math.pow(10, len - 1 - j);
		}
		
		Arrays.sort(alpha);
		int ans = 0;
		int num = 9;
		for (int i = 25; i > 15; i--)
			ans += alpha[i] * num--;
		
		System.out.println(ans);
		br.close();
	}
}
