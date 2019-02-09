import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	static int[] parent;
	static int[] level;
	static int[] relation;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int i = 0; i < test; i++) {
			
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			parent = new int[200001];
			level = new int[200001];
			relation = new int[200001];
			int cnt = 1;
			int F = sc.nextInt();
			
			for (int j = 0; j < F; j++) {
				String name1 = sc.next();
				String name2 = sc.next();
				
				if (!map.containsKey(name1)) {
					parent[cnt] = cnt;
					relation[cnt] = 1;
					level[cnt] = 1;
					map.put(name1, cnt++);
				}
				
				if (!map.containsKey(name2)) {
					parent[cnt] = cnt;
					relation[cnt] = 1;
					level[cnt] = 1;
					map.put(name2, cnt++);
				}
				merge(map.get(name1), map.get(name2));
			}
		}
	}
	
	public static int find(int u) {
		if (u == parent[u])
			return u;
		
		return parent[u] = find(parent[u]);
	}
	
	public static void merge(int u, int v) {
		u = find(u);
		v = find(v);
		
		if (u == v) {
			System.out.println(relation[v]);
			return;
		}
		
		if (level[u] > level[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		parent[u] = v;
		if (level[u] == level[v])
			level[v]++;
		
		relation[v] += relation[u];
		System.out.println(relation[v]);
	}
}
