/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg2_03_PointClass;

import jdk.nashorn.internal.ir.Symbol;
import java.util.Scanner;
/**
 *alg2_c011_PoleBodu.pdf 1. a 2. uloha
 * @author David Šafařík
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * Vytvoří Point array
     * @param nPoints počet bodů
     * @return vytvořený point array
     */
    private static Point[] createShape(int nPoints){
        Point[] points = new Point[nPoints];
        for(int i = 0; i < nPoints; i++){
            points[i] = createPoint();
        }
        return points;
    }
    
    /**
     * vytvoří Point object
     * @return Point object
     */
    private static Point createPoint(){
        System.out.print("x: ");
        float x = sc.nextFloat();
        System.out.print("y: ");
        float y = sc.nextFloat();
        Point p = new Point(x,y);
        return p;
    }
    
    /**
     * Vytiskne Point array o délce 2
     * @param p Point class array
     * @return String, Point class ToString
     */
    private static String printPointArray(Point[] p){
        return p[0].toString()+"\n"+p[1].toString();
    }
    
    /**
     * výpis pro menu
     * @return 
     */
    private static String menuPrint(){
        return "--------------------------------\n"
                + "0: Konec\n"
                + "1: Přidej bod\n"
                + "2: Obvod\n"
                + "3: Obsah\n"
                + "4: Nejbližší bod k počátku\n"
                + "5: Bod nejdále od počátku\n"
                + "6: Dva nejbližší body\n"
                + "7: Dva nejvzdálenější body\n"
                + "8: Vypiš všechny body\n"
                + "--------------------------------";
    }
    
    public static void main(String[] args){
        System.out.println("Řádkové menu pro NShape");
        //počet bodů zadaných hned na začátku
        int initialPoints, choice;
        //cyklus pro ovládání bodů
        System.out.println("Zadejte počet prvotně zadaných bodů.\n"
                + "Počet menší nebo roven 0 ukončí aplikaci.");
        while((initialPoints = sc.nextInt())>0){
            //vytvoření NShape
            NShape shape = new NShape(createShape(initialPoints));
            do{
                //výpis menu
                System.out.println(menuPrint());
                //načtení volby
                choice = sc.nextInt();
                switch(choice){
                    //konec
                    case 0:
                        break;
                    //přidat bod    
                    case 1:
                        shape.add(createPoint());
                        break;
                    //obvod
                    case 2:
                        System.out.println(shape.perim());
                        break;
                    //obsah
                    case 3:
                        System.out.println(shape.area());
                        break;
                    //bod nejblíž k počátku
                    case 4:
                        System.out.println(shape.nearestOrigin().toString());
                        break;
                    //bod nejdál od počátku
                    case 5:
                        System.out.println(shape.farthestOrigin().toString());
                        break;
                    //nejbližší body
                    case 6:
                        System.out.println(printPointArray(shape.nearestPoints()));
                        break;
                    //nejvzdálenější body
                    case 7:
                        System.out.println(printPointArray(shape.farthestPoints()));;
                        break;
                    //vypiš všechny body
                    case 8:
                        System.out.println(shape.toString());
                        break;
                }
                String holder = sc.nextLine();
            }while(choice > 0);
            System.out.println("Zadejte počet prvotně zadaných bodů.\n"
                + "Počet menší než 0 ukončí aplikaci.");
        }
    }
}
