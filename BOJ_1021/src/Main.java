import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			int position = arr[i];
			int move = 0;
			
			if (position != 1) {
				if ((N / 2) + 1 >= position) {
					move -= (position - 1);
					cnt += (position - 1);
				} else {
					move += (N - position + 1);
					cnt += (N - position + 1);
				}
			}
			move(arr, N, move);
			N--;
		}
		System.out.println(cnt);
		br.close();
	}
	
	public static void move(int[] arr, int N, int moveCnt) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) continue;
			
			arr[i] += moveCnt;
			
			if (arr[i] > N) {
				arr[i] %= N;
			} else if (arr[i] < 0) {
				arr[i] = N + arr[i];
			} else if (arr[i] == 0) {
				arr[i] = N;
			}
			arr[i]--;
		}
	}
}
