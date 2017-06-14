/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {

	public static void main(String[] args) {                
		try {
                    String line;
                    BufferedReader in = new BufferedReader(new FileReader("H:\\022 data struct\\words.dat"));
                        String first = in.readLine();
                        char initold = first.charAt(0); //initialize, set initold to be "a"
                        int count = 1;  //the count for numbers of words
                        int i = 0;      //the count for charactors from a to z
                        
                        while ((line = in.readLine()) != null) {
                            char init = line.charAt(0);  
                            
                            //check if the first letter of the word has changed
                            if (init == initold){
                                count = count+1;
                            }
                            else{
                                System.out.println("Number for "+initold+" is "+count);
                                i = i+1;    //update to next charactor
                                count = 1;     //initialize the count of the words
                            }
                            initold = init;     //set the charactor to the one we just tested
                        }
                        // for z only, since we got out of the while loop.
                        System.out.println("Number for "+initold+" is "+count);
			
		} catch (IOException e) {
                    e.printStackTrace();
		} 

	}
}  

        
        
  
