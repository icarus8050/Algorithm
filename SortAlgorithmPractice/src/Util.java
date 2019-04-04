
public class Util {

	public static void printArray(int[] arr) {
		for (int i = 1; i <= arr.length; i++) {
			System.out.printf("%3d ", arr[i - 1]);
			
			if (i % 20 == 0)
				System.out.println();
		}
	}
}
