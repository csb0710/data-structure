package sorting_algorithm;

public class QuickSort {
	static int partition(int list[], int left, int right) {
		int pivot, temp, low, high;
		
		pivot = list[left];
		low = left + 1;
		high = right;
		
		while(low < high) {
			while(list[low] < pivot)
				low++;
			while(list[high] > pivot)
				high--;
			if(low < high) {
				temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		}
		temp = list[left];
		list[left] = list[high];
		list[high] = temp;
		
		return high;
		
	}
	
	static void quick_sort(int list[], int left, int right) {
		if(left < right) {
			int q = partition(list, left, right);
			quick_sort(list, left, q-1);
			quick_sort(list, q+1, right);
		}
	}
	
	public static void main(String[] args) {
		int[] list = new int[10];
		for(int i = 0; i < 10; i++)
			list[i] = (int)(Math.random()*100);
		for(int i = 0; i < 10; i++)
			System.out.println(list[i]);
		System.out.println("");
		quick_sort(list, 0, 9);
		for(int i = 0; i < 10; i++)
			System.out.println(list[i]);

	}

}
