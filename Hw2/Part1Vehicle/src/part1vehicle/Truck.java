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
public class Truck extends Vehicle {
    // Fields (Variables)
    private double loadCapacity;
    private int towingCapacity;

    // Constructor methods
    /* Constructs a default Truck with no input */
    public Truck () {
        // you write
    }
    /* Constructs a default Truck with a string input for the name. */
    public Truck(String manufacturer, int cylinders, Person owner, double load, int tow) {
        // you write!
    }
    /* Constructs copy of a Truck object */
    public Truck(Truck other) {
        // you write!
    }

    // Mutator methods
    // Obtain the values of each Truck field
    public double getLoadCap() {
        // you write!
        return 0;
    }
    public int getTowingCap() {
        // you write!
        return 0;
    }
    
    // Accessor methods
    // Change the values of each Vehicle field
    public void setLoadCap(double load) {
        // you write!
    }
    public void setTowingCap(int tow) {
        // you write!
    }

    /**
     *
     * @return all fields concatenated into a string
     */
    @Override
    public String toString() {
        // you write1
        return "";
    }

    /**
     * Determines if a Truck object is equal to any other object
     * @param other (Any other input object)
     * @return boolean value if Truck Object and input Object have the same values
     */
    @Override
    public boolean equals(Object other) {      
         
        if ( other == null ) {
                return false;
        } 
        else if ( this.getClass() != other.getClass() ) {
                return false;
        } 
        else {
                Truck truck = (Truck)other;
                if (this.getLoadCap().equals(truck.getLoadCap())){
                    return "Loading Capacty is the same";
                }
                if (this.getTowingCap().equals(truck.getTowingCap()))
                    return "Towing Capacty is the same";

        }
        return true;
    }
}
