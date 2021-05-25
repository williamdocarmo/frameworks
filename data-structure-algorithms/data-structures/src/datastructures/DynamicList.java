package datastructures;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicList<T> implements Iterable<T> {

	private T[] array;
	private int length = 0;
	private int capacity = 0;

	public DynamicList() {
		this(16);
	}

	public DynamicList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		}
		this.capacity = capacity;
		array = (T[]) new Object[capacity];
	}

	public int size() {
		return this.length;
	}

	public boolean isEmpty() {
		return this.length == 0;
	}

	public T get(int index) {
		return array[index];
	}

	public void set(int index, T element) {
		this.array[index] = element;
	}

	public void clear() {
		for (int i = 0; i < capacity; i++) {
			array[i] = null;
		}
		length = 0;
	}

	public void add(T element) {
		if (length + 1 >= capacity) {
			if (capacity == 0) {
				capacity = 1;
			} else {
				capacity *= 2;
			}
			T[] tmparray = (T[]) new Object[capacity];
			for (int i = 0; i < length; i++) {
				tmparray[i] = array[i];
			}
			array = tmparray;
		}
		array[length++] = element;
	}

	public boolean remove(T element) {
		for (int i = 0; i < length; i++) {
			if (array[i].equals(element)) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}
	
	public T removeAt(int index) {
		if (index >= length || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		T element = array[index];
		T[] tmparray = (T[]) new Object[length - 1];
		for (int i = 0, j = 0; i < length; i++, j++) {
			if (i == index) {
				j--;
			} else {
				tmparray[j] = array[i];
			}
		}
		array = tmparray;
		capacity = --length;
		return element;
	}
	
	public boolean contains(T element) {
		return indexOf(element) != -1;
	}

	public int indexOf(T element) {
		for (int i = 0; i < length; i++) {
			if (array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			int index = 0;

			public boolean hasNext() {return index < length;}

			public T next() {return array[index++];}
		};
	}

	public String toString() {
		if (length == 0) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder(length).append("[");
			for (int i = 0; i < length - 1; i++) {
				sb.append(array[i] + ",");
			}
			return sb.append(array[length - 1] + "]").toString();
		}
	}

}
