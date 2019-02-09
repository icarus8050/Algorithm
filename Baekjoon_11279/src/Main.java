import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ArrayList<Integer> output = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			
		});
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			
			if(x > 0)
				pq.offer(x);
			else {
				if(!pq.isEmpty())
					output.add(pq.poll());
				else
					output.add(0);
			}
		}
		for (int i = 0; i < output.size(); i++)
			System.out.println(output.get(i));
	}
}
