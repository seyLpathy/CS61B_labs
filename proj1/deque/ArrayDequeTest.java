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
		t1.printDeque();
		assertEquals(4,t1.size());
		assertEquals(7,(int) t1.get(2));

	}
}
