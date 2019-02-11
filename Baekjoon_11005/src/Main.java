import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		while (N / B != 0) {
			int rest = N % B;
			
			insertNumber(rest);
			N /= B;
		}
		
		insertNumber(N);
		System.out.println(result);
		br.close();
	}
	
	public static void insertNumber(int num) {
		if (num < 10)
			result.insert(0, num);
		else
			result.insert(0, (char) (num + 55));
	}
}
