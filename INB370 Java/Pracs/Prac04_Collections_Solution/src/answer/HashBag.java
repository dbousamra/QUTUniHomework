package answer;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import question.BagException;

/**
 * An implementation of the Bag class based on HashMaps.
 * 
 * @author Colin Fidge
 * @version 2.0
 *
 * @param <E> the type of elements contained in the bag
 */
public class HashBag<E> extends Bag<E> {

	/* The data structure used to implement bags
	 *
	 * Only elements with a positive number of occurrences
	 * in the bag appear in the map.  Elements that occur
	 * zero times in the bag are not stored in the map.
	 */
	private Map<E, Integer> contents;

	public HashBag() {
		contents = new HashMap<E, Integer>();
	}

	@Override public void add(E newElement, int quantity) throws BagException {
		if (quantity < 0)
			throw new BagException("Attempt to add negative number of items to bag");
		else if (contents.containsKey(newElement)) // already in bag
			contents.put(newElement, quantity + contents.get(newElement));
		else // new element for bag
			contents.put(newElement, quantity);
	}

	@Override
	public int quantity(E element) {
		if (contents.containsKey(element)) // element is in bag
			return contents.get(element);
		else // element not in bag at all
			return 0;
	}

	@Override
	public void remove(E oldElement, int numToGo) throws BagException {
		if (numToGo < 0) 
			throw new BagException("Attempt to remove negative number of items");
		else if (quantity(oldElement) < numToGo) // try to remove too many
			throw new BagException("Attempt to remove nonexistent items");
		else
			contents.put(oldElement, quantity(oldElement) - numToGo);
	}

	@Override
	public Set<E> toSet() {
		return contents.keySet();
	}

	/**
	 * An iterator for bags.  This implementation does not guarantee
	 * the order of distinct elements, but returns all copies of the
	 * same element together.
	 */
	@Override
	public Iterator<E> iterator() {
		ArrayList<E> allElements = new ArrayList<E>();
		for (E element : toSet())
			for (int index = quantity(element); index > 0; index--)
				allElements.add(element);
		return allElements.iterator();
	}

	/**
	 * Returns the total number of elements in the bag, counting
	 * duplicates.
	 * 
	 * @return the total number of elements in the bag
	 */
	@Override
	public int size() {
		int total = 0;
		for (E element : toSet())
			total += quantity(element);
		return total;
	}

}
