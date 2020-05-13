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
        try{
            while(true){
                try {
                    String startFile = sc.next();
                    String finishFile = sc.next();
                    c.load(startFile, finishFile);
                    break;
//                }catch(IOException e){
//                  tadyto by prekrylo FileNotFoundException  
//                }catch(IllegalArgumentException e){
//                    System.out.println(e.getMessage() + "Zadej znovu.");
                } catch (FileNotFoundException | IllegalArgumentException e) {
                    System.out.println("Zadany soubor neexistuje nebo je to neco jinyho");
                    e.printStackTrace();
                }
            }
            System.out.println(c.getResults());
            System.out.println("Zadej jmeno vysledkoveho souboru.");
            String resultFile = sc.next();
            c.saveResults(resultFile);
        }catch(IOException e){
            System.out.println("Nepovedlo se");
        }
    }
    
}
