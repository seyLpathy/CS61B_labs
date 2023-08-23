package deque;

public interface Deque<item> {
	item removeLast();
	item removeFirst();
	void addLast(item x);
	void addFirst(item x);
	default boolean isEmpty(){return size()==0;};
	int size();
	item get(int index);

	void printDeque();
	boolean equal(Object o);
}
