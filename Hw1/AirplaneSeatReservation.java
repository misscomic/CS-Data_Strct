/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplaneseatreservation;

import java.util.Arrays;

/**
 *
 * @author diederich // Change to you full name
 */
public class AirplaneSeatReservation {
    char[][] seats;
    
    // Constructor method
    AirplaneSeatReservation(int numOfRows, int numOfColumns) {
        seats = new char[numOfRows][numOfColumns];
        for(int i = 0; i < numOfRows; i++) 
            for(int j = 0; j < numOfColumns; j++)
                seats[i][j] = (char)(65+j);
    }
    
    void reserveSeat(int row, char col) {
        row = row - 1;              //update row     
        int ascii = (int) col;      //update charactor into ascii code         
        seats[row][ascii-65]=(char)88;    //turn character into "X"
    }
    
    void freeSeat(int row, char col) {
        int ascii = (int) col;
        seats[row-1][ascii-65]=col;     //turn "X" into given character    
    }
    
    int getNumberOfSeatsAvailable() {
        int value = 0;      //intialize the count number
        for(int i = 0; i < seats.length ; i++) 
            for(int j = 0; j < seats[0].length ; j++)
                if(seats[i][j] == (char)88)
                    value = value + 1;      //count the number of "X"
        value = seats.length * seats[0].length - value;         //calculate available seats 
        return value;
    }
    
    void displaySeats() {
        for (int n = 0; n < seats.length ; n++){
            System.out.print(n+1);          //display the number of row
            System.out.print(seats[n]);     //display the seats in that row
            System.out.print("\n");         //start a new line for next row
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AirplaneSeatReservation airplane1 = new AirplaneSeatReservation(8,4);
        airplane1.displaySeats();
        System.out.println(airplane1.getNumberOfSeatsAvailable());
        airplane1.reserveSeat(2, 'C');
        airplane1.reserveSeat(2, 'D');
        airplane1.reserveSeat(6, 'B');
        System.out.println(airplane1.getNumberOfSeatsAvailable());
        airplane1.displaySeats();
        airplane1.freeSeat(2, 'C');
        System.out.println(airplane1.getNumberOfSeatsAvailable());
        airplane1.displaySeats();
    }
    
}
