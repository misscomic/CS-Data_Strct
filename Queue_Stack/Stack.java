/******************************************************************************
 *
 *  A generic stack, implemented using a linked list. Each stack
 *  element is of type T.  
 *
 ******************************************************************************/

import java.util.NoSuchElementException;

public class Stack<T> {
    private int n;          // size of the stack
    private Node top;		// top of stack

    // helper linked list class
    private class Node {
        private T data;
        private Node next;
    }

   /**
     * Initializes an empty stack.
     */
    public Stack() {
        top = null;
        n = 0;
    }

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    public void push(T item) {
        Node oldtop = top;
        top = new Node();
        top.data = item;
        top.next = oldtop;
        n++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        T item = top.data;		// save item to return
        top = top.next;			// delete first node
        n--;
		return item;			// return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
		}
        return top.data;
    }
}

