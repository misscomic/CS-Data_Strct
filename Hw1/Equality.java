/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equality;

/**
 *
 * @author Diederich // Change to you full name
 */
public class Equality {

        public static boolean ifEqual (int[] array) {            
            boolean value = false;   //initialize boolean value
            for(int j=0; j < array.length; j++)      
                for(int k=j+1; k < array.length; k++)
                    if(k!=j && array[k]==array[j] )
                    //test if there's duplicates in array                           
                        value = true;
                        //update boolean value
            
            return value;
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] input1 = {51,30,56,-24,14,56}; // Placeholder for array
        int[] input2 = {51,30,56,-24,14,17,89,98}; // Placeholder for array
        //I've put the arrays in hw1 example into these two places
        
        boolean result1; // Placeholder for result of method call on first array
        boolean result2; // Placeholder for result of method call on first array
                
        result1 = ifEqual(input1);
        result2 = ifEqual(input2);
        
        System.out.print("The 1st array has duplicated numbers?"
                +result1+"     ");
        System.out.print("The 2nd array has duplicated numbers?"
                +result2);        
        //Display the results
    }

    private static class j<T0, T1> {

        public j() {
        }
    }
    
}
