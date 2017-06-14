/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlellist;

/**
 *
 * @author yli140
 */
public class SingleLList<T> {
    public class Node {
        public T item;
        public Node link;

        public Node( ) {
            item = null;
            link = null;
        }

        public Node(T newItem, Node linkValue) {
            item = newItem;
            link = linkValue;
        }
        
    } //End of Node inner class   
   

    private Node head;

    public SingleLList( ) {
        head = null;
    }

    /**
    Adds a node at the start of the list with the specified data.
    The added node will be the first node in the list.
    */
    public void addToStart(T itemName) {
        head = new Node(itemName, head);
    }

    /**
    Removes the head node and returns true if the list contains at
    least one node. Returns false if the list is empty.
    */
    public boolean deleteHeadNode( ) {
        if (head != null) {
            head = head.link;
            return true;
        }
        else
            return false;
    }

    /**
    Returns the number of nodes in the list.
    */
    public int size( ) {
        int count = 0;
        Node position = head;
        while (position != null) {
            count++;
            position = position.link;
        }
        return count;
    }

    public boolean contains(T item) {
        return (find(item) != null);
    }

    /**
    Finds the first node containing the target item, and returns a
    reference to that node. If target is not in the list, null is
    returned.
    */
    private Node find(T target) {
        Node position = head;
        T itemAtPosition;
        while (position != null) {
            itemAtPosition = position.item;
            if (itemAtPosition.equals(target))
                return position;
            position = position.link;
        }
        return null; //target was not found
    }

    public void outputList( ) {
        Node position = head;
        while (position != null) {
            System.out.println(position.item );
            position = position.link;
        }
    }

    public boolean isEmpty( ) {
        return (head == null);
    }

    public void clear( ) {
        head = null;
    }

    
    public void removeTail(Node ptr){
        if (ptr.link.link == null){
            ptr.link = null;
        }
        else{
            removeTail(ptr.link);
        }   
    }

    public void printEveryOther(Node ptr){
        if (ptr == null) return;
        System.out.print( ptr.item +" ");
        if (ptr.link != null){       
        printEveryOther(ptr.link.link);  
        }
        
    }
    public void printReverse(Node ptr){
        if (ptr == null) return;
        printReverse( ptr.link );             
        System.out.print( ptr.item +" "); 
    }
    
    
    public void printUpDownEveryOther(Node ptr){        
        System.out.print(ptr.item + " ");
        if (ptr.link == null || ptr.link.link == null) return;
        printUpDownEveryOther( ptr.link.link );
        System.out.print(ptr.item+ " ");
        
    }
    
    public void display( ) {
        Node position = head;
        while (position != null) {
            System.out.print(position.item + ", ");
            position = position.link;        
        }
    }
    
public static void main(String [ ] args){
    
    SingleLList list = new SingleLList();
    
    list.addToStart("purple");
    list.addToStart("orange");
    list.addToStart("yellow");
    list.addToStart("pink");
    list.addToStart("blue");
    list.addToStart("green");
    list.addToStart("red");       
    
    System.out.print("The original list:");
    list.display();
    
    list.removeTail(list.head);
    System.out.print("\n"+"Removed Tail List: ");
    list.display();
    
    System.out.print("\n"+"Print Every Other (tail removed) List: ");
    list.printEveryOther(list.head);   

    System.out.print("\n"+"Print Reversed (tail removed) List: ");
    list.printReverse(list.head);
    
    System.out.print("\n"+"Print Up-down Every Other (tail removed) List: ");
    list.printUpDownEveryOther(list.head);
    
}      
}
