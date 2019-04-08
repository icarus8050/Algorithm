import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static final int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int bundle = MAX;
		int piece = MAX;
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			bundle = Math.min(bundle, Integer.parseInt(input[0]));
			piece = Math.min(piece, Integer.parseInt(input[1]));
		}
		
		bundle = Math.min(bundle, piece * 6);
		System.out.println(N / 6 * bundle + Math.min(bundle, N % 6 * piece));
		br.close();
	}
}
