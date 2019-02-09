import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, K;
	static int[] visit = new int[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		Arrays.fill(visit, -1);
		
		bfs();
		System.out.println(visit[K]);
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		visit[N] = 0;
		
		while(!queue.isEmpty()) {
			N = queue.poll();
			
			if (N == K)
				break;
			
			if (N + 1 <= 100000 && visit[N + 1] == -1) {
				queue.add(N + 1);
				visit[N + 1] = visit[N] + 1;
			}
			
			if (N - 1 >= 0 && visit[N - 1] == -1) {
				queue.add(N - 1);
				visit[N - 1] = visit[N] + 1;
			}
			
			if (N * 2 <= 100000 && visit[N * 2] == -1) {
				queue.add(N * 2);
				visit[N * 2] = visit[N] + 1;
			}
		}
	}
}
