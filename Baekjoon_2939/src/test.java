
public class test {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		swap(a, b);
		System.out.println(a + " " + b);
		
	}
	
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = a;
	}
}
