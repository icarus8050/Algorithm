import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[] ox = new boolean[N + 1];
		int[] score = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			if (st.nextToken().equals("1"))
				ox[i] = true;
			else
				ox[i] = false;
		}
		
		for (int i = 1; i <= N; i++) {
			if (ox[i])
				score[i] = score[i - 1] + 1;
			else
				score[i] = 0;
		}
		int result = 0;
		for (int p : score)
			result += p;
		System.out.println(result);
		br.close();
	}
}
