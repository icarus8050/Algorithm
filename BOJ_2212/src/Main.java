import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < N - 1; i++)
			list.add(arr[i + 1] - arr[i]);
		
		Collections.sort(list);
		for (int i = 0; i < K - 1; i++) {
			if (!list.isEmpty())
				list.remove(list.size() - 1);
		}
		
		int res = 0;
		for (int num : list)
			res += num;
		
		System.out.println(res);
		br.close();
	}
}
