/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_competition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Šafařík
 */
public class Main {
public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Zadej jmena vstupnich souboru:");
        Competition c = new Competition();
        String startFile = sc.next();
        String finishFile = sc.next();
        try{
            while(true){
                try {
                    c.load(startFile, finishFile);
                    break;
                } catch (FileNotFoundException ex) {
                    System.out.println("Neexistujici soubor.");
                }
            }
            System.out.println(c.getResults());
            System.out.println("Zadej jmeno vysledkoveho souboru.");
            String resultFile = sc.next();
            c.saveResults();
        }catch(IOException e){
            System.out.println("Nepovedlo se");
        }
    }
    
}
