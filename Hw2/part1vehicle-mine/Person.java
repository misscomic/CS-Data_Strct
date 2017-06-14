/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part1vehicle;

/**
 *
 * @author Kyle Diederich
 */
public class Person {
    private String name;

    // Constructor methods
    /* Constructs a default Person with no input */
    public Person () {
        // you write!
        
    }

    /* Constructs a default Person with a string input for the name. */
    public Person(String theName) {
        // you write!
    }

    /* Constructs copy of a Person object */
    public Person(Person theObject) {
        // you write!
    }

    /* Returns the stored name of a Person object */
    public String getName() {
        // you write!
        return "";
    }

    /* Changes the name of Person object */
    public void setName(String theName) {
        // you write!
    }

    /* Constructs a default person with no input */

    /**
     * Overridden default Java object method
     * @return a string for the name
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Determines if a Person object is equal to any other object
     * @param other (Any other input object)
     * @return boolean value if two Person objects have the same value
     */
    @Override
    public boolean equals(Object other) { //NOTE: DO NOT CHANGE THIS METHOD
        if ( other == null ) {
                return false;
        } 
        else if ( this.getClass() != other.getClass() ) {
                return false;
        } 
        else {
                Person person = (Person)other;
                return (this.getName().equals(person.getName()));
        }
    }    
}
