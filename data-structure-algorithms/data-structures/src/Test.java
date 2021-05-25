import java.util.LinkedList;

import datastructures.DynamicList;
import datastructures.DoublyLinkedList;
import datastructures.Queue;
import datastructures.Stack;

public class Test {
	
	public static void main(String[] args) {
		// arrayList();
		// doublyLinkedList();
		// stack();
		queue();
		
	}
	
	private static void queue() {
		Queue<String> queue = new Queue<String>();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.dequeue();
		queue.dequeue();
		queue.enqueue("X");
		
	}
 
	private static void stack() {
		Stack<String> stack = new Stack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.pop();
		stack.pop();
		stack.push("X");
		
	}

	private static void doublyLinkedList() {
		DoublyLinkedList<String> doubleyLinkedList = new DoublyLinkedList<String>();
		doubleyLinkedList.add("A");
		doubleyLinkedList.add("B");
		doubleyLinkedList.add("C");
		doubleyLinkedList.add("E");
		System.out.println(doubleyLinkedList);
		
		doubleyLinkedList.addLast("F");
		System.out.println(doubleyLinkedList);
		
		doubleyLinkedList.addFirst("Z");
		System.out.println(doubleyLinkedList);
		
		doubleyLinkedList.removeAt(3);
		System.out.println(doubleyLinkedList);
	}

	private static void arrayList() {
		DynamicList<String> array = new DynamicList<String>(2);
		array.add("A");
		array.add("B");
		System.out.println(array);
		
		array.remove("B");
		System.out.println(array);
	}

}
