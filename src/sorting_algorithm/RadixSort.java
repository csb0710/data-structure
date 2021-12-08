package sorting_algorithm;

public class RadixSort {
	static int Buckets = 10;
	static int Digits = 4;
	
	static void radix_sort(int[] list, int n) {
		Queue[] queues = new Queue[Buckets];
		int i, b, d, factor = 1;
		
		for(b = 0; b < Buckets; b ++)  // queues 속 모든 큐가 객체이기 때문에 각각 생성해줘야 한다
			queues[b] = new Queue();
		
		for(d = 0; d < Digits; d++) {
			for(i = 0; i < n; i++) {
				int index = (list[i] / factor) % 10;
				queues[index].enqueue(list[i]);
			}
			i = 0;
			for(b = 0; b < Buckets; b++)
				while(!queues[b].is_empty())
					list[i++] = queues[b].dequeue();
			
			factor *= 10;
		}
	}
	
	public static void main(String[] args) {
		int[] list = new int[10];
		for(int i = 0; i < 10; i++)
			list[i] = (int)(Math.random()*100);
		for(int i = 0; i < 10; i++)
			System.out.println(list[i]);
		System.out.println("");
		radix_sort(list, 10);
		for(int i = 0; i < 10; i++)
			System.out.println(list[i]);
	}

}
