/** Performs some basic linked list tests. */
public class ArrayDeque<T> {
	private int size;
	private T[] array;
	private int nextFirst;
	private int nextLast;


	public ArrayDeque() {
		size = 0;
		array = (T[]) new Object[8];
		nextFirst = 0;
		nextLast = 0;
	}

	private void resize(int newSize) {
		T[] array2 = (T[]) new Object[newSize];
		System.arraycopy(array, 0, array2, 0, size);
		array = array2;
		nextLast = size;
		nextFirst = newSize - 1;

	}


	public void addFirst(T item) {
		array[nextFirst] = item;
		if (nextFirst == 0) {
			nextFirst = array.length - 1;
		} else {
			nextFirst -= 1;
		}
		size += 1;
		if (size == 0.5 * array.length) {
			resize(array.length * 2);
		}

		

	}

	public void addLast(T item) {
		array[nextLast] = item;
		if (nextLast == array.length - 1) {
			nextLast = 0;
		} else {
			nextLast += 1;
		}

		size += 1;

		if (size == 0.5 * array.length) {
			resize(array.length * 2);
		}
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
		if (size == 0) {
			return null;
		}

		T output = array[nextFirst + 1];
		
		if (nextFirst == array.length - 1) {
			nextFirst = 0;
		} else {
			nextFirst += 1;
		}
		size -= 1;

		if (size == 0.25 * array.length) {
			resize(array.length / 2);
		}

		return output;

	}

	public T removeLast() {
		if (size == 0) {
			return null;
		}
		
		T output = array[nextLast - 1];
		
		if (nextLast == 0) {
			nextLast = array.length - 1;
		} else {
			nextLast -= 1;
		}

		size -= 1;

		if (size == 0.25 * array.length) {
			resize(array.length / 2);
		}

		return output;
	}

	public T get(int index) {
		return array[index];

	}
}
