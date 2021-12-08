package list.linkedlist.implementation;

public class Main {

	public static void main(String[] args) {
		LinkedList numbers = new LinkedList();
		numbers.addFirst(30);
		numbers.addFirst(20);
		numbers.addFirst(10);
		numbers.remove(1);
		LinkedList.ListIterator i = numbers.listIterator();
		while(i.hasNext()) {
			if((int)i.next() == 20) {
				i.add(25);
			}
		}
		System.out.println(numbers);
	}
}
