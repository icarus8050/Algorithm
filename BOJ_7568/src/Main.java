import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] rank = new int[N];
		Arrays.fill(rank, 1);
		
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Pair(height, weight));
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				
				if (compare(list.get(i), list.get(j)))
					rank[i]++;
			}
		}
		
		for (int r : rank)
			System.out.print(r + " ");
		System.out.println();
		br.close();
	}
	public static boolean compare(Pair a, Pair b) {
		if (a.height < b.height && a.weight < b.weight)
			return true;
		return false;
	}
}

class Pair {
	int height, weight;
	public Pair(int height, int weight) {
		this.height = height; this.weight = weight;
	}
}