package deque;

import afu.org.checkerframework.checker.oigj.qual.O;

public class LinkedListDeque<item> {
	private class interNode {
		interNode prev;
		item member;
		interNode next;

		public interNode(interNode f, item m, interNode s) {
			prev = f;
			member = m;
			next = s;
		}
	}

	private interNode sentinel;
	int size;

	public LinkedListDeque() {
		sentinel = new interNode(sentinel, null, sentinel);
		size = 0;
	}

	public void addFirst(item x) {
		/**    Adds an item of type T to the front of the deque. You can assume that item is never null.*/
		if (isEmpty()) {
			sentinel.next = new interNode(sentinel, x, sentinel);
			sentinel.prev = sentinel.next;
		} else {
			sentinel.next.prev = new interNode(sentinel, x, sentinel.next);
			sentinel.next = sentinel.next.prev;
		}
		size = size + 1;
	}

	public void addLast(item x) {
		/**    Adds an item of type T to the back of the deque. You can assume that item is never null.*/
		if (isEmpty()) {
			sentinel.prev = new interNode(sentinel.prev, x, sentinel);
			sentinel.next = sentinel.prev;
		} else {
			sentinel.prev.next = new interNode(sentinel.prev, x, sentinel);
			sentinel.prev = sentinel.prev.next;
		}
		size = size + 1;
	}

	public boolean isEmpty() {
		/** Returns true if deque is empty, false otherwise.*/
		return size() == 0;
	}

	public int size() {
		/**Returns the number of items in the deque.*/
		return size;
	}

	public void printDeque() {
		/**Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line.*/
		interNode p = sentinel;
		int t = 0;
		while (t <= size()) {
			System.out.print(p.member);
			System.out.print(" ");
			p = p.next;
			t = t + 1;
		}
		System.out.println();

	}

	public item removeFirst() {
		/**Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
		if (isEmpty()) {
			return null;
		} else {
			item first = sentinel.next.member;
			sentinel.next = sentinel.next.next;
			sentinel.next.prev = sentinel;
			size = size - 1;
			return first;
		}

	}

	public item removeLast() {
		/**Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
		if (isEmpty()) {
			return null;
		} else {
			item last = sentinel.prev.member;
			sentinel.prev = sentinel.prev.prev;
			sentinel.prev.next = sentinel;
			size = size - 1;
			return last;
		}
	}

	public item get(int index) {
		/**Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
		 If no such item exists, returns null. Must not alter the deque!*/
		interNode p = sentinel;
		if (index > size()) {
			return null;
		} else {
			while (index != 0) {
				p = p.next;
				index = index - 1;
			}
			return p.member;
		}
	}

	private item helper(int a, interNode s) {
		if (a == 0) {
			return s.member;
		} else {
			return helper(a - 1, s.next);
		}
	}

	public item getRecursive(int index) {
		if (index > size()) {
			return null;
		}
		return helper(index, sentinel);
	}
	public boolean equal(Object o){
		if (o instanceof LinkedListDeque){
			LinkedListDeque<item> p = (LinkedListDeque<item>) o;
				if (p.size()==size()){
					for (int i = 1;i<=size();i++){
						if (p.get(i)!=get(i)){
							return false;
						}
					}
				}
				return false;
		}
		return false;
	}
}