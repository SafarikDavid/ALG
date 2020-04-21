/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;

/**
 *
 * @author David Šafařík
 */
public abstract class Client {
    String first_name;
    String last_name;
    ArrayList<Account> accounts = new ArrayList<>();

    public Client(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public void createAccountWithInitialBalance(double balance){
        this.addAccount(new Account(balance));
    }
    
    public void addAccount(Account acc) {
        this.accounts.add(acc);
    }
    
    public double getFullBalance(){
        double sum = 0;
        for(Account a : accounts){
            sum += a.getBalance();
        }
        return sum;
    }
    
    public abstract String getClientName();
    
}
