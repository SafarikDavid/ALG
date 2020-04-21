/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import bank.*;

/**
 *
 * @author David Šafařík
 */
public class Main {
    public static void main(String[] args){
        Person pekar = new Person("Karel","Ptáček");
        Person svecova = new Person("Karolina","Drábková");
        Company automobilka = new Company("Škoda");
        
        pekar.createAccountWithInitialBalance(1000);
        pekar.createAccountWithInitialBalance(500);
        svecova.createAccountWithInitialBalance(1200);
        automobilka.createAccountWithInitialBalance(120);
        
        System.out.println(pekar.getClientName() + " " + pekar.getFullBalance());
        System.out.println(svecova.getClientName() + " " + svecova.getFullBalance());
        System.out.println(automobilka.getClientName() + " " + automobilka.getFullBalance());
    }
}
