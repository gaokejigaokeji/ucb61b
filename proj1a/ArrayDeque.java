/** Performs some basic linked list tests. */
public class ArrayDeque <T> {
	private int size;
	public T[] array;
	private int nextFirst;
	private int nextLast;


	public ArrayDeque() {
		size = 0;
		T[] array = (T[]) new Object[8];
		nextFirst = 0;
		nextLast = 1;
	}


	public void addFirst(T item) {
		array[nextFirst] = item;
		if (nextFirst == 0) {
			nextFirst = array.length - 1;
		} else {
			nextFirst -= 1;
		}

		size += 1;

	}

	public void addLast(T item) {
		array[nextLast] = item;
		if (nextLast == array.length - 1) {
			nextLast = 0;
		} else {
			nextLast += 1;
		}

		size += 1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void printDeque() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	public T removeFirst() {
		T output = array[nextFirst + 1];
		array[nextFirst + 1] = null;
		if (nextFirst == array.length - 1) {
			nextFirst = 0;
		} else {
			nextFirst += 1;
		}
		size -= 1;
		return output;

	}

	public T removeLast() {
		T output = array[nextLast - 1];
		array[nextLast - 1] = null;
		if (nextLast == 0) {
			nextLast = array.length - 1;
		} else {
			nextLast -= 1;
		}
		size -= 1;
		return output;
	}

	public T get(int index) {
		return array[index];

	}
}