import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] card_1 = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			card_1[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(card_1);
		
		int M = Integer.parseInt(br.readLine());
		int[] exist = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			int left = 0; int right = N - 1;
			while (right >= left) {
				int mid = (left + right) / 2;
				
				if (card_1[mid] == target) {
					exist[i] = 1;
					break;
				}
				else if (card_1[mid] > target)
					right = mid - 1;
				else
					left = mid + 1;
			}
		}
		
		for (int i = 0; i < M; i++)
			System.out.print(exist[i] + " ");
		br.close();
	}
}
