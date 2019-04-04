import java.util.Scanner;

public class Main {

	static boolean[] isBroken = new boolean[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int answer = 0;
		
		for (int i = 0; i < M; i++)
			isBroken[sc.nextInt()] = true;
		
		answer = Math.abs(N - 100);
		
		for (int i = 0; i <= 1000000; i++) {
			int length = isMovable(i);
			
			if (length > 0) {
				int press = Math.abs(N - i);
				answer = Math.min(answer, length + press);
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
	
	public static int isMovable(int channel) {
		boolean flag = false;
		int length = 0;
		
		while (true) {
			if (isBroken[channel % 10]) {
				break;
			} else {
				length++;
				channel /= 10;
				if (channel == 0) {
					flag = true;
					break;
				}
			}
		}
		
		return (flag ? length : 0);
	}
}
