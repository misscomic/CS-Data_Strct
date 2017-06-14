/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2contacts;
import java.util.ArrayList;
/**
 *
 * @author Kyle Diederich
 */
public class Contact {
    private String first, last, phone, email;

    /* Constructors */
    public Contact() {	
       ArrayList contact = new ArrayList();
    }

    public Contact(String fir, String las, String ph, String eml) {
        // you write!
        this.first = fir;
        this.last = las;
        this.phone = ph;
        this.email = eml;
               
    }

    /* Mutator Methods */
    public void setFirst(String fir) {
        // you write!
        this.first = fir;    
    }
    public void setLast(String las) {
        // you write!
        this.last = las;
    }
    public void setPhone(String ph) {
        // you write!
        this.phone = ph;
    }
    public void setEmail(String em)	{
        // you write!
        this.email = em;
    }

    /**
     * Overridden default Java object method
     * @return Return all fields concatenated into a string
     */
    @Override
    public String toString() {
        // you write!
        return first+last+phone+email;
    }
}
