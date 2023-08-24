package deque;
import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;
public class ArrayDequeTest {
	@Test
	public void rudimentaryTest(){
		ArrayDeque<Integer> t1= new ArrayDeque<>();
		t1.addFirst(6);
		t1.addFirst(7);
		t1.addFirst(8);
		t1.addLast(9);
		t1.printDeque();
		t1.addLast(10);
		//t1.printDeque();
		assertEquals(5,t1.size());
		assertFalse(t1.isEmpty());
		for (int i : t1){
			System.out.print(i);
			System.out.print(" ");
		}
	}


	@Test
	public void randomizeTest(){
		ArrayDeque<Integer> sampleA = new ArrayDeque<>();
		LinkedListDeque<Integer> sampleB = new LinkedListDeque<>();
		int N = 5000;
		for (int i = 0;i<N;i++){
			int operationNumber = StdRandom.uniform(2, 5);
			int ranAdd = StdRandom.uniform(0,100);
			// 0,1 remove first/last
			if (sampleA.isEmpty()){
				operationNumber = StdRandom.uniform(2,4);
			};
			if (operationNumber==0){
				int first = sampleA.removeFirst();
				sampleB.removeFirst();
				System.out.println("we have removed first "+first);
				assertEquals(sampleA.size(),sampleB.size());
			}
			if(operationNumber==1){
				int last = sampleA.removeLast();
				sampleB.removeLast();
				System.out.println("we have removed last "+last);
				assertEquals(sampleA.size(),sampleB.size());

			}
			if (operationNumber==2){
				sampleA.addFirst(ranAdd);
				sampleB.addFirst(ranAdd);
				assertEquals(sampleA.size(),sampleB.size());
				System.out.println("we have added first " + ranAdd);
			}
			if (operationNumber==3){
				sampleA.addLast(ranAdd);
				sampleB.addLast(ranAdd);
				assertEquals(sampleA.size(),sampleB.size());
				System.out.println("we have added last " + ranAdd);
			}
			if (operationNumber==4){
				int ranIndex = StdRandom.uniform(0,sampleA.size());
				System.out.println("we are gonna check the index of "+ranIndex);
				assertEquals(sampleA.get(ranIndex),sampleB.get(ranIndex));
				System.out.println("get function works well");
			}
			System.out.println("current size is "+sampleA.size());
			sampleA.printDeque();
			System.out.println();
			sampleB.printDeque();
		}
	}

	@Test
	public void timeTest(){
		ArrayDeque<Integer> sampleTime = new ArrayDeque<>();
		ArrayDeque<Integer> timescale = new ArrayDeque<>();
		timescale.addLast(100);
		timescale.addLast(10000);
		timescale.addLast(1000000);
		timescale.addLast(2000000);
		timescale.addLast(4000000);
		for (int arraySize:timescale) {
			int randomVar = StdRandom.uniform(100, 10000);
			for (int i = 0; i < arraySize; i++) {
				sampleTime.addLast(randomVar);
			}
			Stopwatch sw = new Stopwatch();
			int t = sampleTime.get(sampleTime.size() / 2);
			double timeCost = sw.elapsedTime();
			System.out.println("data size:" + arraySize + " costTime " + timeCost);
		}
	}
}
