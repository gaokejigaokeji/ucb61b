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
        nextLast = 1;
    }
    private void resize(int newSize) {
        T[] array2 = (T[]) new Object[newSize];
        System.arraycopy(array, 0, array2, 0, size);
        array = array2;
        nextLast = size;
        nextFirst = newSize - 1;

    }


    public void addFirst(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = array.length - 1;
        } else {
            nextFirst -= 1;
        }
        size += 1;
    }
    public void addLast(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
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
        int index;

        if (nextFirst == array.length - 1) {
            index = 0;
        } else {
            index = nextFirst + 1;
        }


        while (index != nextLast) {
            System.out.print(array[index] + " ");
            index = (index + 1) % array.length;
        }
        System.out.println();

    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        if (nextFirst == array.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst += 1;
        }

        T output = array[nextFirst];
        array[nextFirst] = null;
        size -= 1;

        if (size <= 0.25 * array.length) {
            resize(array.length / 2);
        }

        return output;

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (nextLast == 0) {
            nextLast = array.length - 1;
        } else {
            nextLast -= 1;
        }

        T output = array[nextLast];
        array[nextLast] = null;
        size -= 1;
        if (size <= 0.25 * array.length) {
            resize(array.length / 2);
        }
        return output;
    }

    public T get(int index) {
        if (index < 0 || index >= array.length || array[index] == null) {
            return null;
        } else {
            return array[index];
        }
    }
}
