package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import net.sf.saxon.om.Item;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        BuggyAList<Integer> sampleA = new BuggyAList<>();
        AListNoResizing<Integer> sampleB = new AListNoResizing<>();
        sampleA.addLast(4);
        sampleB.addLast(4);
        sampleA.addLast(5);
        sampleB.addLast(5);
        sampleA.addLast(6);
        sampleB.addLast(6);
        assertEquals(sampleA.removeLast(),sampleB.removeLast());
        assertEquals(sampleA.removeLast(),sampleB.removeLast());
        assertEquals(sampleA.removeLast(),sampleB.removeLast());

    }

    @Test
    public void randomizedTest(){
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> M = new BuggyAList<>();
      int N = 5000;
      for (int i = 0; i < N; i += 1) {
        int operationNumber = StdRandom.uniform(0, 4);
        if (L.size()==0&&M.size()==0){
          operationNumber = StdRandom.uniform(0,2);
        }
        if (operationNumber == 0) {
          // addLast
          int randVal = StdRandom.uniform(0, 100);
          L.addLast(randVal);
          M.addLast(randVal);
          System.out.println("addLast(" + randVal + ")");
        }
        else if (operationNumber == 1) {
          int size = L.size();
          System.out.println("size: " + size);
          assertEquals(size,M.size());
        }
        else if (operationNumber == 2){
          int last = L.getLast();
          System.out.println("getLast: " + last);
          assertEquals(last,(int)(M.getLast()));
        }
        else {
          int remove =L.removeLast();
          System.out.println("removeLast: "+ remove);
          assertEquals(remove,(int)(M.removeLast()));
          System.out.println("size change to: " + L.size());
        }

      }
    }
}
