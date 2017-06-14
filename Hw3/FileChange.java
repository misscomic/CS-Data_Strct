/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filechange;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yli140
 */
public class FileChange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
            //create temporary file
            
            try{                
                File temp = new File("H:\\022 data struct\\tempX.txt");        
                if (! temp.createNewFile()){
                    throw new IOException("File name existed");                          
                }                
            }
            catch( IOException e ){
                e.printStackTrace();
            }
                        
            //read the old file and copy changed lines into temp file
            try {
                String line;
                String Output = "";
                BufferedReader in = new BufferedReader(new FileReader("H:\\022 data struct\\star.txt"));                
               
                while ((line = in.readLine()) != null) {  
                    List<String> newline = new ArrayList<String>();
                    /**find blanks
                     * first, split the line into words or empty entries
                     */
                    String result[] = line.split(" ");
                    for (int i=0; i < (result.length); i++){                        
                        String word = result[i];    //test every entry in the list   
                        
                        if (word.length()>= 1){  //check if it's not an empty entry but a word                           
                            newline.add(word);  //add to the array
                            String joined = String.join(" ", newline);  //join arraylist by " "

                        }
                        }
                    
                    String joined = String.join(" ", newline);  //join arraylist by " "

                    //write changed line in temp file
                    BufferedWriter fw = new BufferedWriter(new FileWriter("H:\\022 data struct\\tempX.txt",true));
                    //test System.out.println(joined);
                    fw.write(joined);  
                    fw.newLine();
                    fw.close();
			
                }
                
                // copy the content in temp file into old file
                FileInputStream instream = null;
                FileOutputStream outstream = null;

                try{
                    File infile =new File("H:\\022 data struct\\tempX.txt");
                    File outfile =new File("H:\\022 data struct\\star.txt");

                    instream = new FileInputStream(infile);
                    outstream = new FileOutputStream(outfile);

                    byte[] buffer = new byte[1024];

                    int length;
                    //copying
                    while ((length = instream.read(buffer)) > 0){
                        outstream.write(buffer, 0, length);
                    }
                    
                    //close the input and output
                    instream.close();
                    outstream.close();

                }catch(IOException ioe){
                        ioe.printStackTrace();
                 }
                    } 
            catch (IOException e) {
                e.printStackTrace();
            } 
            
            // Finally, delete the tempX file
            try{                
                File dele = new File("H:\\022 data struct\\tempX.txt");        
                if (dele.delete()){                          
                }
                else{
                    throw new IOException("File not found.");                
                }
                
            }
            catch( IOException e ){
                e.printStackTrace();
            }
                
    }
    
}
