import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] prize_1 = {5000000, 3000000, 2000000, 500000, 300000, 100000};
		int[] prize_2 = {5120000, 2560000, 1280000, 640000, 320000};
		int[] people_1 = {1, 2, 3, 4, 5, 6};
		int[] people_2 = {1, 2, 4, 8, 16};
		int result;
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			result = 0;
			for (int i = 0; i < prize_1.length; i++) {
				if (a == 0) break;
				if (a > people_1[i])
					a -= people_1[i];
				else {
					result += prize_1[i];
					break;
				}
			}
			
			for (int i = 0; i < prize_2.length; i++) {
				if (b == 0) break;
				if (b > people_2[i])
					b -= people_2[i];
				else {
					result += prize_2[i];
					break;
				}
			}
			
			System.out.println(result);
		}
		br.close();
	}
}
