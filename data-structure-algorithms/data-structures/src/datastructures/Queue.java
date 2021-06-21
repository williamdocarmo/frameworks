package datastructures;
import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

	private DoublyLinkedList<T> list = new DoublyLinkedList<T>();

	public Queue() {
	}

	public Queue(T element) {
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void enqueue(T element) {
		list.addLast(element);
		System.out.println(this);
	}

	public T dequeue() {
		T element = list.removeFirst();
		System.out.println(this);
		return element;
	}

	public T peek() {
		return list.peekFirst();
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
