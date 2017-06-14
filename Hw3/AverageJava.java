/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package average.java;
import java.util.Scanner;
        
/**
 *
 * @author yli140
 */
public class AverageJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // initialization
        int integIn;
        int IntegEntered = 0;
        int count = 0;
        int i = 0;
        int sum = 0;
        double average = 0;            

        
        while(true){
            try{
                System.out.println("Enter the number of elements to find their average:");   
                Scanner scan = new Scanner(System.in);
                
                int numN = scan.nextInt();  
                
                //exception for incorrect number N
                if (numN < 1){
                    throw new Exception("Incorrect format Exception.");
                }
                else{
                    count = numN;
                    break;
                }}

            catch(Exception e){
                // ask for new N
                System.out.println("Incorrect format Exception." );            
            }
        }        

        //if N is in correct format                      
        while(i<count){
            while(true){
                try{
                    System.out.println("Enter an integer:");
                    Scanner scan2 = new Scanner(System.in);
                    //exception for incorrect integer 
                    if (!(scan2.hasNextInt())){
                        throw new NumberFormatException("Incorrect number format.");                    
                    }
                    else{
                        sum = sum + scan2.nextInt();
                        i = i+1;
                        break;
                        }}                
                catch(NumberFormatException e){
                    //ask for new input integer
                    System.out.println("Incorrect number format." );
                }
            }}
        average = (double) sum / count;
        System.out.println("The average is "+average);
    }
    
}