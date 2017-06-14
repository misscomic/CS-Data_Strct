/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2contacts;

import java.util.ArrayList;
import java.util.Scanner;

/**
* The ContactDatabase class stores each contact in an arraylist.
* Methods exist to add new contacts, search contacts, delete, and print contacts
* to the console.
* 
* @author Kyle Diederich
*/

public class Part2Contacts {
    private ArrayList<Contact> contacts;		// ArrayList of contact
    private static final int QUIT = 0;			// Menu choices
    private static final int ADD = 1;
    private static final int LISTALL = 2;
    private static final int SEARCH = 3;
    private static final int DELETE = 4;

    /**
    * Default constructor - make a new ArrayList object with parameter type Contact
    */
    Part2Contacts() {
        contacts = new ArrayList<Contact>(); // No changes needed
    }

    /**
    * inputContact inputs contact information from the keyboard
    * following appropriate prompts to the user.
    * It then stores this new contact in the contacts ArrayList.
    */
    public void inputContact() {

        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Input first name:");
        String first = keyboard.nextLine();
        contacts.add(first);
        
        System.out.print("Input last name:");
        String last = keyboard.nextLine();
        contacts.add(last);
        
        System.out.print("Input phone number:");
        String phone = keyboard.nextLine();
        contacts.add(phone);
        
        System.out.print("Input email address:");
        String email = keyboard.nextLine();
        contacts.add(email);        
    
    }

    /**
    * displayAll iterates through the ArrayList of contacts and outputs each one
    * to the screen.
    */
    public void displayAll() {
        // you write!
        System.out.println("Name (first, last):" +first+last+ "Phone:" 
                +phone+ "Email:" +email);
    }

    /**
    * displayMatch inputs a keyword from the user.
    * It then iterates through the ArrayList of contacts and outputs each one
    * to the screen if the contact information contains the keyword.
    */
    public void displayMatch() {
        Scanner match = new Scanner(System.in);
        String key = null;
        System.out.print("Input keywords:");
        key = match.nextLine();
        
        for (int i=0; i<contacts.size();i++){
            Contact contacts = this.contacts.get(i);
            if (contacts.toString().equals(key)){
                return Contact contacts;
            }
            else{
                return "Not found";
            }        
        }           
    }

    /**
    * deleteMatch inputs a keyword from the user.
    * It then iterates through the ArrayList of contacts and asks the user
    * if the contact should be deleted, if the contact information contains the keyword.
    */
    public void deleteMatch() {
        Scanner del = new Scanner(System.in);
        String key = null;
        System.out.print("Input keywords:");
        key = del.nextLine();
        
        for (int i=0; i<contacts.size();i++){
            Contact contacts = this.contacts.get(i);
            if (contacts.toString().equals(key)){
                System.out.print("Delete contact?");
                String answer = del.nextLine();
                
                if( !(answer.equalsIgnoreCase("yes")) ){
                    contacts.remove(Contact);
                }
                
            }
            else{
                return "Not found";
            }        
        }
    }
    
    // DO NO CHANGE THE MAIN METHOD!!
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // DO NOT CHANGE THIS METHOD!!
        Part2Contacts cdb = new Part2Contacts();
        Scanner scan = new Scanner(System.in);
	int choice = ADD;

	// Main menu
	while (choice != QUIT)	{
            System.out.println();
            System.out.println("Choose from the following:");
            System.out.println("0) Quit");
            System.out.println("1) Add new contact");
            System.out.println("2) List all contacts");
            System.out.println("3) Search contacts by keyword and display");
            System.out.println("4) Search contacts by keyword and remove");
            choice = scan.nextInt();
            switch (choice) {
		case ADD:       cdb.inputContact();
                    break;
		case LISTALL:   cdb.displayAll();
                    break;
		case SEARCH:    cdb.displayMatch();
                    break;
		case DELETE:    cdb.deleteMatch();
		break;
            }
        }
    }
    
}
