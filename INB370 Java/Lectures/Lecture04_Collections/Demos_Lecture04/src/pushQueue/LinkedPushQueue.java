package pushQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;
import java.util.LinkedList;

/**
 * A linked list implementation of a "push" queue.  (We have inserted
 * comments only for methods whose functionality differs from the
 * standard Queue and Collection methods.)
 * 
 * @author Colin Fidge
 * @version 1.0
 *
 * @param <E> the type of the queue's elements
 */
public class LinkedPushQueue<E> extends PushQueue<E> {

	private Queue<E> elements; // the queue's contents

	/**
	 * When constructed a push queue has a fixed, positive maximum capacity.
	 * 
	 * @param capacity the fixed capacity of the queue
	 * @throws PushQueueException if the given capacity is zero or negative
	 */
	public LinkedPushQueue(int capacity) throws PushQueueException {
		super(capacity);
		elements = new LinkedList<E>();
	}

	public E element() throws NoSuchElementException {
		return elements.element();
	}

	/**
	 * Inserts a new element into the queue, dislodging
	 * the oldest one if the queue was already full.
	 * 
	 * @param newElement the new element to be added
	 */
	public boolean offer(E newElement) {
		if (size() == maxCapacity())
			elements.remove();
		elements.offer(newElement);
		return true; // always succeeds
	}

	public E peek() {
		return elements.peek();
	}

	public E poll() {
		return elements.poll();
	}

	public E remove() throws NoSuchElementException {
		return elements.remove();
	}

	/**
	 * Inserts a new element into the queue, dislodging
	 * the oldest one if the queue was already full.
	 * 
	 * @param newElement the new element to be added
	 */
	public boolean add(E newElement) {
		return offer(newElement); // add and offer are the same for push queues
	}

	/**
	 * Add all the elements in the given collection to the queue,
	 * dislodging any old ones if necessary.
	 * 
	 * @param newElements a collection of new elements to be added
	 * @return true if any elements were added, false otherwise
	 */
	public boolean addAll(Collection<? extends E> newElements) {
		for (E newElement : newElements)
			offer(newElement);
		return newElements.size() > 0;
	}

	public void clear() {
		elements.clear();
	}

	public boolean contains(Object o) {
		return elements.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return elements.containsAll(c);
	}

	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public Iterator<E> iterator() {
		return elements.iterator();
	}

	/**
	 * This optional operation is not supported for push queues, which allow
	 * elements to be removed from the head only.
	 */
	public boolean remove(Object o) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation on push queue");
	}

	/**
	 * This optional operation is not supported for push queues, which allow
	 * elements to be removed from the head only.
	 */
	public boolean removeAll(Collection<?> c) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation on push queue");
	}

	/**
	 * This optional operation is not supported for push queues, which allow
	 * elements to be removed from the head only.
	 */
	public boolean retainAll(Collection<?> arg0) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation on push queue");
	}

	public int size() {
		return elements.size();
	}

	public Object[] toArray() {
		return elements.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return elements.toArray(a);
	}

}
