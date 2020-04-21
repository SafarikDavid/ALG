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
public class Account {
    double balance;

    public Account() {
    }
    
    public Account(double initial_balance) {
        this.balance = initial_balance;
    }

    public double getBalance() {
        return balance;
    }
    
    public void deposit(double deposited_ammount) {
        this.balance += deposited_ammount;
    }
    
    public void withdraw(double withdrawed_ammount) {
        this.balance -= withdrawed_ammount;
    }
}
