
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = RandomNumberMaker.getNumber();
		
		Util.printArray(arr);
		System.out.println("------------------------------------------------------");
		SelectionSort.sort(arr);
		Util.printArray(arr);
	}
	
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j])
					minIndex = j;
			}
			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
}
