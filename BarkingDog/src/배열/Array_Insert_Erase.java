package ¹è¿­;

public class Array_Insert_Erase {
	static int len;
	public static void main(String[] args) {
		insert_test();
		erase_test();

	}

	private static void insert_test() {
		System.out.println("***** insert_test *****\n");
		int arr[] = {10, 20, 30, 0, 0, 0, 0, 0, 0, 0};
		len = 3;
		insert(3, 40, arr); // 10 20 30 40
		printArr(arr, len);
		insert(1, 50, arr); // 10 50 20 30 40
		printArr(arr, len);
		insert(0, 15, arr); // 15 10 50 20 30 40
		printArr(arr, len);
		
	}

	private static void printArr(int[] arr, int len) {
		for(int i = 0; i < len; i++) 
			System.out.print(arr[i] + " ");
		System.out.print("\n\n");
		
	}

	private static void insert(int idx, int num, int[] arr) {

		for (int i = arr.length-1; i > idx; i--) {
			arr[i] = arr[i-1];
		}
		arr[idx] = num;
		len++;
		
	}

	private static void erase_test() {
		System.out.println("***** erase_test *****\n");
		int arr[] = {10, 50, 40, 30, 70, 20, 0, 0, 0, 0};
		len = 6;
		erase(4, arr); // 10 50 40 30 20
		printArr(arr, len);
		erase(1, arr); // 10 40 30 20
		printArr(arr, len);
		erase(3, arr); // 10 40 30
		printArr(arr, len);
		
	}

	private static void erase(int idx, int[] arr) {
		for (int i = idx; i < len; i++) {
			arr[i] = arr[i+1];			
		}
		len--;
		
	}

}
