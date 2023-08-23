package deque;
import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Comparator;
class IntComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer a, Integer b) {
		return Integer.compare(a.compareTo(b), 0);
	}
}
public class MaxArrayDequeTest {
	@Test
	public void MaxTest(){
		IntComparator myComparator = new IntComparator();
		MaxArrayDeque<Integer> maxSample = new MaxArrayDeque<>(myComparator);
		maxSample.addFirst(34);
		maxSample.addFirst(35);
		maxSample.addLast(36);
		maxSample.addLast(37);
		assertEquals(37,(int) maxSample.max());

	}
}
