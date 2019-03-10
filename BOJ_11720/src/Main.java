import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		String input = br.readLine();
		while (--N >= 0)
			sum += input.charAt(N) - '0';
		System.out.println(sum);
		br.close();
	}
}
