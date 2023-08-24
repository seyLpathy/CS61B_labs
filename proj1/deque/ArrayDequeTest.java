package deque;
import org.junit.Test;
import static org.junit.Assert.*;
public class ArrayDequeTest {
	@Test
	public void rudimentaryTest(){
		ArrayDeque<Integer> t1 = new ArrayDeque<>();
		t1.addLast(6);
		t1.addFirst(5);
		t1.addLast(7);
		t1.addLast(6);
		t1.addFirst(23);
		t1.addLast(34);
		t1.addFirst(27);
		t1.addLast(67);
		t1.printDeque();
		assertEquals(8,t1.size());
		assertEquals(27,(int) t1.get(2));
		/** test about resizing problems*/
		t1.addLast(100);
		t1.printDeque();
		assertEquals(27,(int)t1.removeFirst());



	}
}
