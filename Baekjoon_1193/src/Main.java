import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i;
		int a = 1; //첫 항
		int d = 2; //공차
		int layer = 1; //계층
		
		int child;	//분자
		int parent;	//분모
		
		while (N > a) {
			layer++;
			a += d;
			d++;
		}
		
		i = N - (a - (d - 1)) - 1;
		
		if ((layer % 2) == 0) {
			child = 1; parent = layer;
			while(i > 0) {
				child++;
				parent--;
				i--;
			}
		}else {
			child = layer; parent = 1;
			
			while(i > 0) {
				child--;
				parent++;
				i--;
			}
		}
		System.out.println(child + "/" + parent);
	}
}
