/** Performs some basic linked list tests. */

public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private int length;
    private T[] array;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque() {
        size = 0;
        array = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        length = 8;
    }

    private void resize(int newSize) {
        T[] array2 = (T[]) new Object[newSize];
        for (int i = 0, j = 0; i < size; i++, j++) {
            array2[i] = get(j);
        }
        array = array2;
        nextLast = size;
        nextFirst = newSize - 1;
        length = newSize;
    }

    private int minusOne(int i) {
        if (i == 0) {
            i = length - 1;
        } else {
            i -= 1;
        }
        return i;
    }

    private int plusOne(int i) {
        if (i == length - 1) {
            i = 0;
        } else {
            i += 1;
        }
        return i;
    }

    public void addFirst(T item) {
        if (size == length) {
            resize(length * 2);
        }
        array[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size == length) {
            resize(length * 2);
        }
        array[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int index = plusOne(nextFirst);
        while (index != nextLast) {
            System.out.print(array[index] + " ");
            index = (index + 1) % length;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        T output = array[nextFirst];
        array[nextFirst] = null;
        size -= 1;
        if (length > 8 && size <= 0.25 * length) {
            resize(length / 2);
        }
        return output;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = minusOne(nextLast);
        T output = array[nextLast];
        array[nextLast] = null;
        size -= 1;
        if (length > 8 && size <= 0.25 * length) {
            resize(length / 2);
        }
        return output;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) {
            return null;
        } else {
            int firstDex = plusOne(nextFirst);
            return array[(firstDex + index) % length];
        }
    }
}
