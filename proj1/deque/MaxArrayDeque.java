package deque;

import java.util.Comparator;

public class MaxArrayDeque<item> extends ArrayDeque<item>{
	private Comparator<item> C;
	public MaxArrayDeque(Comparator<item> x){
		super();
		C = x;
	}
	public item max(){
		/* return the max item*/
		return max(C);

	}
	public item max(Comparator<item> c){
		if (isEmpty()) {
			return null;
		}
		item maxValue = get(0);
		for (int i = 0; i < size(); i++) {
			if (c.compare(get(i), maxValue) > 0) {
				maxValue = get(i);
			}
		}
		return maxValue;
	}
}
