package search_algorithm;

public class SearchBinary {
	static int search_binary(int list[], int key, int low, int high) {
		int middle;
		
		if(low <= high) {
			middle = (low + high) / 2;
			if(key == list[middle])
				return middle;
			else if(key < list[middle])
				return search_binary(list, key, low, middle-1);
			else
				return search_binary(list, key, middle+1, high);
		}
		
		return -1;
	}
	
	static int search_binary2(int list[], int key, int low, int high) {
		int middle;
		
		while(low <= high) {
			middle = (low + high) / 2;
			if(key == list[middle])
				return middle;
			else if(key < list[middle])
				high = middle - 1;
			else
				low = middle + 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int list[] = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(search_binary(list, 4, 0, 9));
		System.out.println(search_binary2(list, 8, 0, 9));

	}

}
