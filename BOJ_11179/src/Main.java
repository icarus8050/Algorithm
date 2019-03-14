import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int cnt = 0;
		int result = 0;
		
		while (N >= 1) {
			cnt++;
			queue.offer(N % 2);
			N /= 2;
		}
		
		while (!queue.isEmpty()) {
			cnt--;
			if (queue.poll() == 1)
				result += (int) Math.pow(2, cnt);
		}
		System.out.println(result);
		br.close();
	}
}
