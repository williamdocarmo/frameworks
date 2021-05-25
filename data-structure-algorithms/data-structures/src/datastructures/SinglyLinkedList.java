package datastructures;
public class SinglyLinkedList<T> {

	private Node head = null;
	private Node tail = null;

	class Node {
		private Node next;
		private T data;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	public void add(T data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void display() {
		Node current = head;
		if (head == null) {
			return;
		}
		while (current != null) {
			current = current.next;
		}
	}

}