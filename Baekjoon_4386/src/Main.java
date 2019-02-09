import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int[] parent;
	public static Star[] stars;
	public static Edge[] edges;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		parent = new int[N];
		stars = new Star[N];
		edges = new Edge[N * (N - 1) / 2];
		int cnt = 0;
		double result = 0;
		int link_cnt = 0;
		
		for (int i = 0; i < N; i++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			stars[i] = new Star(x, y);
			parent[i] = i;
		}
		sc.close();
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				double cost = Math.sqrt(
						Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2)
						);
				
				edges[cnt++] = new Edge(i, j, cost);
			}
		}
		Arrays.sort(edges);
		
		for (int i = 0; i < cnt; i++) {
			if ( merge(find(edges[i].a), find(edges[i].b)) ) {
				result += edges[i].cost;
				link_cnt++;
				
				if (link_cnt == N - 1) break;
			}
		}
		
		DecimalFormat form = new DecimalFormat("#.##");
		String ans = form.format(result);
		System.out.println(ans);
	}
	
	public static int find(int u) {
		if (u == parent[u])
			return u;
		return parent[u] = find(parent[u]);
	}
	
	public static boolean merge(int u, int v) {
		u = find(u);
		v = find(v);
		
		if (u == v)
			return false;
		
		parent[u] = v;
		return true;
	}
}

class Star {
	double x;
	double y;
	
	public Star(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Edge implements Comparable<Edge>{
	int a;
	int b;
	double cost;
	
	public Edge(int a, int b, double cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge target) {
		// TODO Auto-generated method stub
		if (this.cost > target.cost)
			return 1;
		else if (this.cost == target.cost)
			return 0;
		else
			return -1;
	}
}