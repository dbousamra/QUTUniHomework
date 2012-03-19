package answer;

import java.util.Set;
import java.util.AbstractCollection;
import question.BagException;

/**
 * An abstract data type for bags (multisets).  This class provides
 * a minimal set of methods for creating and manipulating bags.  Many
 * others are possible (such as the bag equivalents of the usual
 * set operations, union, intersection and difference).
 * 
 * Note that bags are a subtype of the general Collection supertype.
 * Since bags (multisets) allow duplicates they do not fit as a subtype
 * of the Set class, which specifies that duplicates are not allowed.
 * 
 * @author Colin Fidge
 * @version 2.0
 *
 * @param <E> the type of elements to go into the bag
 */
public abstract class Bag<E> extends AbstractCollection<E> {

	/**
	 * Returns the number of times the given element appears in the
	 * bag.  Returns zero if the element is not in the
	 * bag at all.
	 * 
	 * @param element the element of interest
	 * @return how many times the element appears in the bag
	 */
	public abstract int quantity(E element);
	
	/**
	 * Adds the specified quantity of the given element to the bag.  No
	 * change is made if the quantity is zero.
	 * 
	 * @param newElement the element to be added to the bag
	 * @param quantity the number of copies of the element
	 * to be added
	 * @throws BagException if the number of elements to add
	 * is negative
	 */
	public abstract void add(E newElement, int quantity)
	throws BagException;
	
	/**
	 * Removes the specified quantity of the given element from the
	 * bag.  No change is made if the quantity is zero.
	 *  
	 * @param oldElement the element to be removed from the bag
	 * @param quantity the number of copies of the element
	 * to be removed
	 * @throws BagException if an attempt is made to remove more
	 * copies of the element than the bag contains or if the
	 * number to be removed is negative
	 */
	public abstract void remove(E oldElement, int quantity)
	throws BagException;

	
	/**
	 * Returns the set of distinct elements in the bag, ignoring
	 * duplicates.  (Elements of type E that occur zero times in the bag are
	 * not returned.)
	 * 
	 * @return a set containing all distinct elements in the bag
	 */
	public abstract Set<E> toSet();
	
}
