package ot.ds.list.arraylist.api;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) {
			LinkedList numbers = new LinkedList();
			numbers.addFirst(30);
			numbers.addFirst(20);
			numbers.addFirst(10);
			ListIterator i = numbers.listIterator();
			while(i.hasNext()) {
				System.out.println(i.next());
			}
	}
	

}
