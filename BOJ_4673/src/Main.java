
public class Main {

	static boolean[] self = new boolean[10036];
	public static void main(String[] args) {
		
		for (int i = 1; i < 10000; i++) {
			self[dn(i)] = true;
			if (!self[i])
				System.out.println(i);
		}
	}
	
	public static int dn(int i) {
		int temp = i;
		int sum = 0;
		while (i != 0) {
			sum += i % 10;
			i /= 10;
		}
		sum += temp;
		return sum;
	}
}
