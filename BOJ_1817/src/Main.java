import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<Integer>();
		if (N > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				queue.offer(Integer.parseInt(st.nextToken()));
		}
		
		int res = 0;
		int temp = M;
		while (!queue.isEmpty()) {
			int book = queue.poll();
			if (temp == M)
				res++;
			
			if (temp >= book)
				temp -= book;
			else {
				temp = M;
				temp -= book;
				res++;
			}
		}
		System.out.println(res);
		br.close();
	}
}
