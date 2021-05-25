package datastructures;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

	private DoublyLinkedList<T> list = new DoublyLinkedList<T>();

	public Stack() {
	}

	public Stack(T element) {
		push(element);
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void push(T element) {
		list.addLast(element);
		System.out.println(this);
	}

	public T pop() {
		T element =  list.removeLast();
		System.out.println(this);
		return element;
	}

	public T peek() {
		return list.peekLast();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}

}
