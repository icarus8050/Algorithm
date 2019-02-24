import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++)
			list.add(i + 1);
		
		StringBuilder sb = new StringBuilder();
		
		int idx = 0;
		int iter = M - 1;
		while (!list.isEmpty()) {
			while (iter-- > 0) {
				idx++;
				if (idx == list.size())
					idx = 0;
			}
			
			queue.offer(list.remove(idx));
			if (idx == list.size())
				idx = 0;
			iter = M - 1;
		}
		
		sb.append("<");
		while (!queue.isEmpty()) {
			sb.append(queue.poll()).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		System.out.println(sb);
		sc.close();
	}
}
