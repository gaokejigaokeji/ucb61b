/** Performs some basic linked list tests. */
public class LinkedListDeque <T> {
	private int size;
	private Node sentinel; 

	
	public class Node {
		public T item;
		public Node next;
		public Node prev;

		/** constructor*/
		public Node(T a, Node p, Node n){
			item = a;
			prev = p;
			next = n;
		}
	}

	public LinkedListDeque() {
		size = 0;
		sentinel = new Node(null, null, null);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
	}

	
	public void addFirst(T item) {
		Node t = new Node(item, sentinel, sentinel.next);
		sentinel.next = t;
		t.next.prev = t;
		size += 1;

	}

	public void addLast(T item) {
		Node t = new Node(item, sentinel.prev, sentinel);
		sentinel.prev = t;
		t.prev.next = t;
		size += 1;
	}

	public boolean isEmpty() {
        if (size == 0){
        	return True;
        }
        return False;
    }

    public int size(){
		return size;
	}

    public void printDeque() {
    	for (Node p = sentinel.next; p != sentinel; p = p.next){
    		System.out.print(p.item + " ");
    	}
    	System.out.println();

    }

    public T removeFirst() {
    	if (this.isEmpty){
    		return null;
    	}
    	T item = sentinel.next.item;
    	sentinel.next = sentinel.next.next;
    	sentinel.next.prev = sentinel;
    	size -= 1;
    	return item;

    }

    public T removeLast() {
    	if (this.isEmpty){
    		return null;
    	}
    	T item = sentinel.prev.item;
    	sentinel.prev = sentinel.prev.prev;
    	sentinel.prev.next = sentinel;
    	size -= 1;
    	return item;        
    }

    public T get(int index) {
    	if (index > this.size()){
    		return null;
    	}
        Node ptr = sentinel.next;
        while (index > 0){
        	ptr = ptr.next
        	index -= 1;
        }
        return ptr.item;
    }

    
    public T getRecursive(int index) {
        if (index < 0 || index >= size){
        	return null;
        }
        return helper(index, sentinel.next);
    }

    public T helper(int index, Node ptr){
    	if (index == 0){
    		return ptr.item;
    	}
    	return helper(index - 1, ptr.next);
    }


} 