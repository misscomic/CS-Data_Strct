/******************************************************************************
 *  
 *  Generic max priority queue implementation with a binary heap.
 *  Can be used with a comparator instead of the natural order,
 *  but the generic Key type must still be Comparable.
 *
 ******************************************************************************/

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQ<Key> implements Iterable<Key> {
    private Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    private Comparator<Key> comparator;  // optional Comparator

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    public MaxPQ() {
        this(1);
    }

    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param  initCapacity the initial capacity of this priority queue
     * @param  comparator the order in which to compare the keys
     */
    public MaxPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator the order in which to compare the keys
     */
    public MaxPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    /**
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys, using sink-based heap construction.
     *
     * @param  keys the array of keys
     */
    private void sink(int k) {
    while (2*k <= n) {
      int j = 2*k;
      if (j < n && less(j, j+1)) j++;
      if (!less(k, j)) break;
      exch(k, j);
      k = j;
   }
    }
    public MaxPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1]; 
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();		// Used to maintain invariant of the queue
    }
      


    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key max() {
        if (isEmpty()) 
			throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    // Helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }


    /**
     * Adds a new key to this priority queue.
     *
     * @param  x the new key to add to this priority queue
     */
    public void insert(Key x) {
	if (n > pq.length){
            resize(2*pq.length); 
            //enlarge the size of the binary tree
            //the size will double in the worst case                      
        }
        int k = n+1; 
        pq[k] = x;  //set the new element at the very bottom of the tree
        while (k>1 && less(k/2,k)){ 
            //move it up if it's larger than the parent
            exch(k/2, k);
            k = k/2;
        }               		
		// This line should be the final statement of this method.
		// Only add code above this line.
        assert isMaxHeap();
    }

    /**
     * Removes and returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key delMax() {
		Key max = null; // Added to allow for compilation
                max = max();
                exch(1,n-1);
                sink(1); 
                //go through the queue by move the smallest element on top
                pq[n] = null; //clean the empty node
		
		// These lines should be the final statements of this method.
		// Only add code above these lines.
        assert isMaxHeap();
        return max;
    }

   /***************************************************************************
    * Helper functions for compares and swaps.
    ***************************************************************************/
    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

	// Simple swap method to exchange the locations of two objects in the array.
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // is pq[1..N] a max heap?
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a max heap?
    private boolean isMaxHeap(int k) {
        if (k > n) 
			return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && less(k, left))  
			return false;
        if (right <= n && less(k, right)) 
			return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }


   /***************************************************************************
    * Iterator.
    ***************************************************************************/

    /**
     * Returns an iterator that iterates over the keys on this priority queue
     * in descending order.
     * The iterator does not implement remove() since it's optional.
     *
     * @return an iterator that iterates over the keys in descending order
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {

        // create a new pq
        private MaxPQ<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comparator == null) 
				copy = new MaxPQ<Key>(size());
            else                    
				copy = new MaxPQ<Key>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext() { 
			return !copy.isEmpty();                     
		}
        public void remove() { 
			throw new UnsupportedOperationException();  
		}

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }

}
