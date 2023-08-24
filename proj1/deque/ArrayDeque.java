package deque;
public class ArrayDeque<item> {
	private item[] items;
	private int size;
	private int nextLast;
	private int nextFirst;

	public ArrayDeque() {
		items = (item[]) new Object[8];
		size = 0;
		nextLast = 5;
		nextFirst = 4;
	}

	private void resize(int capacity) {
		item[] a = (item[]) new Object[capacity];
		System.arraycopy(items, 0, a, size, size);
		items = a;
		nextLast = size() * 2;
		nextFirst = size() - 1;
	}

	public int size() {
		return size;
	}

	public void addLast(item x) {
		if (size == items.length) {
			resize(size * 3);
			//geometrical resizing
		}
		items[nextLast] = x;
		size = size + 1;
		if (nextLast + 1 == items.length) {
			nextLast = 0;
		} else {
			nextLast = nextLast + 1;
		}

	}

	public void addFirst(item x) {
		if (size == items.length) {
			resize(size * 3);
		}
		items[nextFirst] = x;
		size = size + 1;
		if (nextFirst == 0) {
			nextFirst = items.length - 1;
		} else {
			nextFirst = nextFirst - 1;
		}


	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void printDeque() {
		System.out.println("current members are displayed below");
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				System.out.print(items[i]);
				System.out.print(' ');
			}
		}
		System.out.println();
	}

	public item get(int index) {
		if (index > size) {
			return null;
		} else {
			item a = null;
			for (int j = 0; j <= items.length; j++) {
				if (items[j] != null) {
					a = items[j + index];
					break;
				}
			}
			return a;
		}
	}
	private void usageCheck(){
		if (items.length >= 16 && size < items.length / 4) {
			resize(size * 4);
		}
	}
	public item removeLast() {
		usageCheck();
        int last;
        if(nextLast==0){
            last = items.length -1;
        }
		else{
			last = nextLast -1;
		}
		item x = get(last);
		size = size - 1;
		nextLast = last;
		return x;
	}
	public item removeFirst(){
		usageCheck();
		int first;
		if(nextFirst== items.length-1){
			first = 0;
		}
		else{
			first = nextFirst -1;
		}
		item x = get(first);
		size = size - 1;
		nextFirst = first;
		return x;
	}

}
