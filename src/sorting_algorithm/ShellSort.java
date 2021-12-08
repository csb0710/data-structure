package sorting_algorithm;

public class ShellSort {
	static void inc_insertion_sort(int[] list, int first, int last, int gap) {
		int i, j, key;
		for(i = first + gap; i <= last; i = i + gap) {
			key = list[i];
			for(j = i - gap; j >= first && list[j] > key; j = j - gap)
				list[j + gap] = list[j];
			list[j + gap] = key;
		}
	}
	
	static void shell_sort(int[] list, int n) {
		int i, gap;
		for(gap = n/2; gap > 0; gap = gap / 2) {
			if((gap % 2) == 0)
				gap++;
			for(i = 0; i < gap; i++)
				inc_insertion_sort(list, i, n-1, gap);
		}
	}
	
	public static void main(String[] args) {
		int[] list = {3, 2, 6, 9, 1, 10, 7, 8, 4, 5};
		int i;
		
		shell_sort(list, 10);
		
		for(i = 0; i < 10; i++) {
			System.out.println(list[i]);
		}
	}

}
