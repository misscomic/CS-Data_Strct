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
public class Vehicle {
    // Fields (Variables)
    private String manufacturer;
    private int cylinders;
    private Person owner;

    // Constructor methods
    /* Constructs a default Vehicle with no input */
    public Vehicle () {
        
    }
    /* Constructs a default Vehicle with a string input for the name. */
    public Vehicle(String man, int cylin, Person own) {
        // you write!
    }
    /* Constructs copy of a Vehicle object */
    public Vehicle(Vehicle other) {
        // you write!
    }

    // Mutator methods
    // Obtain the values of each Vehicle field
    public String getManufacturer() {
        // you write!
        return "";
    }
    public int getCylinders() {
        // you write!
        return 0;
    }
    public Person getOwner() {
        // you write!
        return null;
    }

    // Accessor methods
    // Change the values of each Vehicle field
    public void setManufacturer(String man) {
        // you write!
    }
    public void setCylinders(int cylin) {
        // you write!
    }
    public void setOwner(Person own) {
        // you write!
    }

    /**
     *
     * @return all fields concatenated into a string
     */
    @Override
    public String toString() {
        // you write!
        return "";
    }

    /**
     * Determines if a Vehicle object is equal to any other object
     * @param other (Any other input object)
     * @return boolean value if Vehicle Object and input Object have the same values
     */
    @Override
    public boolean equals(Object other) {
        // you write!
        return true;
    }    
}
