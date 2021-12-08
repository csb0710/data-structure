package sorting_algorithm;

public class MergeSort {
	static void merge(int list[], int left, int mid, int right) {
		int i, j, k, l;
		int[] sorted = new int[100];
		i = left;
		j = mid + 1;
		k = left;
		
		while(i <= mid && j <= right) {
			if(list[i] <= list[j])
				sorted[k++] = list[i++];
			else
				sorted[k++] = list[j++];
		}
		if(i > mid)
			for(l = j; l <= right; l++)
				sorted[k++] = list[l];
		else
			for(l = i; l <= mid; l++)
				sorted[k++] = list[l];
		for(l = left; l <= right; l++)
			list[l] = sorted[l];
	}
	
	static void merge_sort(int list[], int left, int right) {
		int mid;
		if(left < right) {
			mid = (left + right) / 2;
			merge_sort(list, left, mid);
			merge_sort(list, mid + 1, right);
			merge(list, left, mid, right);
		}
	}
	
	public static void main(String[] args) {
		int[] list = {3, 2, 6, 9, 1, 10, 7, 8, 4, 5};
		int i;
		
		merge_sort(list, 0, 9);
		
		for(i = 0; i < 10; i++)
			System.out.println(list[i]);

	}

}
