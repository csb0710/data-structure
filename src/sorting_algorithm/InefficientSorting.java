package sorting_algorithm;

public class InefficientSorting {
	
	static void selection_sort(int[] list, int n) {
		int i, j, least, temp;
		for(i = 0; i < n - 1; i++) {
			least = i;
			for(j = i + 1; j < n; j++)
				if(list[j] < list[least])
					least = j;
			temp = list[i];
			list[i] = list[least];
			list[least] = temp;
		}
	}
	
	static void insertion_sort(int[] list, int n) {
		int i, j, key;
		for(i = 1; i < n; i++) {
			key = list[i];
			for(j = i-1; j >= 0 && list[j] > key; j = j - 1)
				list[j + 1] = list[j];
			list[j + 1] = key;
		}
	}
	
	static void bubble_sort(int[] list, int n) {
		int i, j, temp;
		for(i = 0; i < n-1; i++)
			for(j = 0; j < n-1-i; j++)
				if(list[j + 1] < list[j]) {
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
	}
	
	public static void main(String[] args) {
		int[] list1 = {3, 2, 6, 9, 1, 7, 8, 4, 5};
		int[] list2 = {2, 1, 5, 7, 4, 9, 8, 6, 3};
		int[] list3 = {5, 7, 1, 3, 9, 6, 2, 8, 4};
		int i;
		int n = 9;

		selection_sort(list1, n);
		insertion_sort(list2, n);
		bubble_sort(list3, n);
				
		for(i = 0; i < n; i++) {
			System.out.println(list1[i]);
		}
		System.out.println("------------------------------");
		
		for(i = 0; i < n; i++) {
			System.out.println(list2[i]);
		}
		System.out.println("------------------------------");
		
		for(i = 0; i < n; i++) {
			System.out.println(list3[i]);
		}
		System.out.println("------------------------------");

	}

}
