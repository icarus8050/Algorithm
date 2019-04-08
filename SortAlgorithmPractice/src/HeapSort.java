
public class HeapSort {

	public static void main(String[] args) {
		int[] arr = RandomNumberMaker.getNumber();
		
		Util.printArray(arr);
		System.out.println("------------------------------------------------------");
		HeapSort.sort(arr);
		Util.printArray(arr);
		
	}
	
	public static void sort(int[] arr) {
		int len = arr.length;
		
		for (int i = len / 2 - 1; i >= 0; i--) {
			heapify(arr, i, len);
		}
		
		for (int i = len - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapify(arr, 0, i);
		}
	}
	
	public static void heapify(int[] arr, int parent, int len) {
		int temp = parent;
		int left = parent * 2 + 1;
		int right = parent * 2 + 2;
		
		if (left < len && arr[temp] < arr[left]) {
			temp = left;
		}
		
		if (right < len && arr[temp] < arr[right]) {
			temp = right;
		}
		
		if (parent != temp) {
			swap(arr, parent, temp);
			heapify(arr, temp, len);
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
