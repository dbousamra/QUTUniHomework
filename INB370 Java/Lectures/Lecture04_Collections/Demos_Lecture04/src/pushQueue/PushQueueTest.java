package pushQueue;

import java.util.Queue;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedHashSet;

/*
 * This JUnit class merely performs a few simple tests on the
 * LinkedPushQueue type.  (It is NOT necessarily a well-designed,
 * comprehensive test suite!)
 */

public class PushQueueTest {

	/* A convenient place to dump the queue's contents */
	String[] testResult = new String[] {};
	
	/* Put three items in a queue of length four */
	@Test
	public void underfullQueue() throws PushQueueException {
		Queue<String> testQueue = new LinkedPushQueue<String>(4);
		testQueue.add("a");
		testQueue.add("b");
		testQueue.add("c");
		testResult = testQueue.toArray(testResult);
		assertArrayEquals(testResult, new String[] {"a", "b", "c"});
	}

	/* Put seven items in a queue of length five */
	@Test
	public void overfullQueue() throws PushQueueException {
		Queue<String> testQueue = new LinkedPushQueue<String>(5);
		testQueue.add("a");
		testQueue.add("b");
		testQueue.add("c");
		testQueue.add("d");
		testQueue.add("e");
		testQueue.add("f");
		testQueue.add("g");
		testResult = testQueue.toArray(testResult);
		assertArrayEquals(testResult, new String[] {"c", "d", "e", "f", "g"});
	}
	
	/* Inspect then remove the element at the front of the queue */
	@Test
	public void peekThenPoll() throws PushQueueException {
		Queue<String> testQueue = new LinkedPushQueue<String>(4);
		testQueue.add("a");
		testQueue.add("b");
		testQueue.add("c");
		testQueue.add("d");
		testQueue.add("e");
		assertEquals(testQueue.peek(), "b");
		testQueue.remove();
		testResult = testQueue.toArray(testResult);
		assertArrayEquals(testResult, new String[] {"c", "d", "e"});
	}
	
	/* Confirm that a queue's capacity and size are distinct */
	@Test
	public void capacityVsSize() throws PushQueueException {
		LinkedPushQueue<String> testQueue = new LinkedPushQueue<String>(4);
		testQueue.add("a");
		testQueue.add("b");
		testQueue.add("c");
		assertEquals(testQueue.size(), 3);
		assertEquals(testQueue.maxCapacity(), 4);
	}
	
	/* Test the ability to add several elements at a time */
	@Test
	public void addSeveralAtATime() throws PushQueueException {
		Queue<String> testQueue = new LinkedPushQueue<String>(6);
		LinkedHashSet<String> someStrings = new LinkedHashSet<String>();
		someStrings.add("w");
		someStrings.add("x");
		someStrings.add("y");
		someStrings.add("z");
		testQueue.addAll(someStrings);
		testQueue.addAll(someStrings);
		testResult = testQueue.toArray(testResult);
		assertArrayEquals(testResult,
				new String[] {"y", "z", "w", "x", "y", "z"});
	}
	
	/* Attempt to construct a queue with zero capacity */
	@Test(expected = PushQueueException.class)
	public void badConstruction() throws PushQueueException {
		@SuppressWarnings("unused")
		Queue<String> illegalQueue = new LinkedPushQueue<String>(0);
	}
}
