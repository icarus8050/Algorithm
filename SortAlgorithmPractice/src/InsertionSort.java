
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = RandomNumberMaker.getNumber();
		
		Util.printArray(arr);
		System.out.println("------------------------------------------------------");
		BubbleSort.sort(arr);
		Util.printArray(arr);
		
	}
	
	public static void sort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			for (int j = i - 1; j >= 0; j++) {
				if (temp > arr[j]) {
					arr[j + 1] = arr[j];
				} else {
					arr[j] = temp;
					break;
				}
			}
		}
	}
}
