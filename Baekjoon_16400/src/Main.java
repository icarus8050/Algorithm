import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int count = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int five, three;
		int N = sc.nextInt();
		sc.nextLine();
		three = 0;
		five = N / 5;
		N %= 5;
		
		while (five >= 0) {
			if (N % 3 == 0) {
				three = N / 3;
				N %= 3;
				break;
			}
			five--;
			N += 5;
		}
		
		System.out.println(five + three);
		sc.close();
	}

}
