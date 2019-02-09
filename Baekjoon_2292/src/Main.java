import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		int count = 1;
		int add = 0;
		int maxNum = 1;
		
		while (N > maxNum) {
			count++;
			add += 6;
			maxNum += add;
		}
		System.out.println(count);
	}
}
