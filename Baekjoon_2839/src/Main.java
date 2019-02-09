import java.util.Scanner;

public class Main {

	static int[] stair;
	static int sum;
	public static void main(String[] args) {
		sum = 0;
		Scanner sc = new Scanner(System.in);
		
		int step = sc.nextInt();
		sc.nextLine();
		
		stair = new int[step];
		for (int i = 0; i < step; i++) {
			stair[i] = sc.nextInt();
			sc.nextLine();
		}
		System.out.println(climbing());
	}
	
	public static int climbing() {
		
		return 0;
	}
}
