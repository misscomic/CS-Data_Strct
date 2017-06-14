/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yli140
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String text = "Star is  v   ery bright, and.";
        String result[] = text.split(" ");
        for (int j = 0;j<result.length; j++){
            System.out.println(result[j]);
            System.out.println(result[j].length()<1);
            
        }
        String list[] = {"fggha","bsdy","c"};
        String very = "verywseuh";
        list.add(very); 
        
        String joined = String.join(" ", list);
        System.out.println(joined);
        
    }
    
}
