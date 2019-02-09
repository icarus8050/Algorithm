import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		long count = 0;
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		sc.nextLine();
		
		while (testCase > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int dist = y - x;
			
			for (long n = 1; ; n++) {
				long powN = n * n;
				long minN = powN - n + 1;
				long maxN = powN + n;
				
				if (minN <= dist && dist <= maxN) {
					if (dist <= powN)
						count = n * 2 - 1;
					else
						count = n * 2;
					break;
				}
			}
			System.out.println(count);
			testCase--;
		}
		sc.close();
	}
}
