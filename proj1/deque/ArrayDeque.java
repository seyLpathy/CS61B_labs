package deque;

import java.util.Iterator;

public class ArrayDeque<item> implements Iterable<item>,Deque<item>{
	private item[] items;
	private int size;
	private int nextLast;
	private int nextFirst;
	private void reset(int next,int first){
		nextLast = next;
		nextFirst = first;
	}
	public ArrayDeque() {
		items = (item[]) new Object[8];
		size = 0;
		reset(4,3);
	}
	private void IncNextLast(){
		nextLast = (nextLast + 1)% items.length;
	}
	private void DecNextLast(){
		nextLast = (nextLast + items.length -1)% items.length;
	}
	private void IncNextFirst(){
		nextFirst = (nextFirst -1 + items.length)% items.length;
	}
	private void DecNextFirst(){
		nextFirst = (nextFirst + 1)%items.length;
	}
	private void checkresize(){
		if (items.length>=16 && 4*size< items.length){
			resize(3*size);
		}
	}
	private item getFirst(){return items[getFirstIndex()];}
	private int getFirstIndex(){return (nextFirst+1)%items.length;}
	private item getLast(){return items[getLastIndex()];}
	private int getLastIndex(){return (nextLast-1+ items.length)% items.length;}

	@Override
	public Iterator<item> iterator(){
		return new ArrayDequeIterator();
	}
	private class ArrayDequeIterator implements Iterator<item>{
		int wizpos;
		public ArrayDequeIterator(){
			wizpos =0;
		}
		@Override
		public boolean hasNext(){
			return wizpos<size;
		}

		@Override
		public item next(){
			item theNext = get(wizpos);
			wizpos = wizpos + 1;
			return theNext;
		}

	}
	private void resize(int capacity) {
		item[] a = (item[]) new Object[capacity];
		int first = getFirstIndex();
		int last = getLastIndex();
		// according to the first and last distribution in the array
		if (first < last){
			System.arraycopy(items,0,a,size,size);
		}
		else{
			System.arraycopy(items,first,a,size,items.length-first);
			System.arraycopy(items,0,a,size+items.length-first,last+1);
			}
		reset(size*2,size-1);
		items = a;
	}


		 //resizing 过程中改变添加位置
	@Override
	public int size() {
		return size;
	}

	@Override
	public void addLast(item x) {
		if (size == items.length) {
			resize(size * 3);
		}
		items[nextLast] = x;
		size = size + 1;
		IncNextLast();
	}

	@Override
	public void addFirst(item x) {
		if (size == items.length) {
			resize(size * 3);
		}
		items[nextFirst] = x;
		size = size + 1;
		IncNextFirst();
	}

	@Override
	public void printDeque() {
		for (int i = 0; i < size(); i++) {
			System.out.print(get(i));
			System.out.print(' ');
		}
	}
	@Override
	public item get(int index) {
		if (size()==0){
			return null;
		}
		int checkIndex = (getFirstIndex()+index)% items.length;
		return items[checkIndex];
	}
	@Override
	public item removeFirst(){
		if (size()==0){
			return null;
		}
		checkresize();
		item Firsted = getFirst();
		items[getFirstIndex()]=null;
		DecNextFirst();
		size = size -1;
		return Firsted;

	}
	@Override
	public item removeLast(){
		if (size()==0){
			return null;
		}
		checkresize();
		item Lasted = getLast();
		items[getLastIndex()]=null;
		DecNextLast();
		size = size -1 ;
		return Lasted;
	}
	@Override
	public boolean equal(Object o){
		if (o instanceof ArrayDeque){
			LinkedListDeque<item> p = (LinkedListDeque<item>) o;
			if (p.size()==size()){
				for (int i = 0;i<size();i++){
					if (p.get(i)!=get(i)){
						return false;
					}
				}
				return true;
			}
			return false;
		}
		return false;
	}
}