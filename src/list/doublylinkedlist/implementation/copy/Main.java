package list.doublylinkedlist.implementation.copy;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList numbers = new DoublyLinkedList();
		numbers.addFirst(30);
		numbers.addFirst(20);
		numbers.addFirst(10);
		DoublyLinkedList.ListIterator i = numbers.listIterator();
		while(i.hasNext()) {
			if((int)i.next() == 20) {
				i.add(25);
			}
		}
		System.out.println(numbers);
	}
}
