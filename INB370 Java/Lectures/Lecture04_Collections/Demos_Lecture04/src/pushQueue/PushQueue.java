package pushQueue;

import java.util.Queue;

/**
 * A "push" queue is a FIFO queue with a bounded capacity in which new elements
 * dislodge old ones when the queue is full.  (For instance, consider a loading
 * dock in a rail yard.  Newly arriving rail carriages can fit alongside the
 * dock until it is fully occupied.  From then on, each new carriage that
 * arrives pushes all of the carriages along and causes the oldest one to be
 * pushed out of the dock.)  This kind of queue is useful for modelling
 * job processing queues in which the value of the job decreases over time.
 * New jobs replace old ones that have "timed out" and are no longer
 * worth processing.
 * 
 * @author Colin Fidge
 * @version 1.0
 *
 * @param <E> the type of the queue's elements
 */
public abstract class PushQueue<E> implements Queue<E> {

	private int capacity; // the queue's maximum size

	/**
	 * When constructed a push queue has a fixed, positive maximum capacity.
	 * 
	 * @param capacity the fixed capacity of the queue
	 * @throws PushQueueException if the given capacity is zero or negative
	 */
	public PushQueue(int capacity) throws PushQueueException {
		if (capacity <= 0)
			throw new PushQueueException("Invalid capacity for push queue");
		else {
			this.capacity = capacity;
		}
	}

	/**
	 * Returns the maximum capacity of this push queue.
	 * 
	 * @return the queue's capacity
	 */
	public int maxCapacity() {
		return capacity;
	}

}
