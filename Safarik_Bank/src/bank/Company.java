/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author David Šafařík
 */
public class Company extends Client{

    public Company(String last_name) {
        super("firma", last_name);
    }

    @Override
    public String getClientName() {
        return first_name + " " + last_name;
    }
    
}
