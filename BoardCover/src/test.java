import java.util.ArrayList;

public class test {
	
	static int[][] test;
	public static void main(String[] args) {
		
		test = new int[5][2];
		test[2][0] = 1;
		
		System.out.println(test(2)[0]);
	}
	
	public static int[] test(int n) {
		test[n][0] += 1;
		
		return test[n];
	}
}
