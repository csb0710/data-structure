package search_algorithm;

public class SequentialSearch {
	int i;
	static int sequential_search(int list[], int key, int low, int high) {
		for(int i = low; i <= high; i++)
			if(list[i] == key)
				return i;
		return -1;
	}
	
	static int sequential_search2(int list[], int key, int low, int high) {
		int i;
		list[high + 1] = key;
		
		for(i = low; list[i] != key; i++)
			;
			
		if(i == high+1) return -1;
		return i;
	}
	
	public static void main(String[] args) {
		int[] list = new int[1000];
		for(int i = 0; i < 10; i++)
			list[i] = (int)(Math.random()*100);
		int result = sequential_search(list, 34, 0, 9);
		System.out.println(result);

	}

}
