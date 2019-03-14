import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int[] cache = new int[N + 1];
		
		for (int i = 1; i <= N; i++)
			cache[i] = i - 1;
		
		int result = (M - 1) + M * cache[N];
		System.out.println(result);
		br.close();
	}
}
