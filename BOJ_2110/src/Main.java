import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		
		int[] house = new int[N];
		
		for (int i = 0; i < N; i++)
			house[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(house);
		
		int result = 0;
		int left = 1;
		int right = house[N - 1] - house[0];
		
		while (left <= right) {
			int cnt = 1;
			int mid = (left + right) / 2;
			int start = house[0];
			
			for (int i = 1; i < N; i++) {
				if (house[i] - start >= mid) {
					start = house[i];
					cnt++;
				}
			}
			
			if (cnt >= C) {
				left = mid + 1;
				result = mid;
			}
			else
				right = mid - 1;
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
