

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = RandomNumberMaker.getNumber();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			
			if (i % 20 == 0)
				System.out.println();
		}
		
		System.out.println();
		System.out.println("----------------------------------");
		
		BubbleSort.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			
			if (i % 20 == 0)
				System.out.println();
		}
		
	}
	
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
