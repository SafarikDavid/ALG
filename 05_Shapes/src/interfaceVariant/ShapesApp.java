package interfaceVariant;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David Šafařík
 */
public class ShapesApp {
    //udelat novou metodu pro sort objektu, ale stahnout si od ni code
    
    public static Scanner sc = new Scanner(System.in);
    
    /**
     * Vytvori objekt circle
     * @return objekt Circle
     */
    private static Circle addCircle(){
        double r = sc.nextDouble();
        return new Circle(r);
    }
    
    /**
     * Vytvori objekt square
     * @return objekt Square
     */
    private static Square addSquare(){
        double a = sc.nextDouble();
        return new Square(a);
    }
    
    /**
     * Vytvori objekt rectangle
     * @return objekt Rectangle
     */
    private static Rectangle addRectangle(){
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        return new Rectangle(a, b);
    }
    
    /**
     * Pocita plochu obrazcu
     * @param shapes
     * @return vypoctenou plochu
     */
    private static double calculateArea(ArrayList<ShapeInterface> shapes){
        double area = 0;
        for(ShapeInterface s : shapes){
            area += s.computeArea();
        }
        return area;
    }
    
    private static void printShapes(ArrayList<ShapeInterface> shapes){
        for(ShapeInterface s : shapes){
            System.out.println(s.toString());
        }
    }
    
    private static String printMenu(){
        return "-------------------\n"
                + "Hlavni menu\n"
                + "1: pridej shapes\n"
                + "2: spocitej obsah\n"
                + "3: vypis shapes\n"
                + "0: konec\n"
                + "-------------------";
    }
    
    private static String printAddShapeMenu(){
        return "-------------------\n"
                + "Pridej shape menu\n"
                + "1: circle\n"
                + "2: square\n"
                + "3: rectangle\n"
                + "0: navrat\n"
                + "-------------------";
    }
    
    public static void main(String[] args){
        System.out.println("Vitejte v shapes");
        //deklarace promennych
        int choice;
        int chooseShape;
        ArrayList<ShapeInterface> shapes = new ArrayList();
        //cyklus programu
        do{
            //vypis menu
            System.out.println(printMenu());
            switch (choice = sc.nextInt()){
                //konec
                case 0:
                    System.out.println("Ukoncuji program.");
                    break;
                //pridej shape
                case 1:
                    do{
                        //vypis menu pro vyber shapes
                        System.out.println(printAddShapeMenu());
                        switch (chooseShape = sc.nextInt()){
                            //navrat, bez pridani
                            case 0:
                                System.out.println("Vracim se zpet do hlavniho menu.");
                                break;
                            //pridej circle
                            case 1:
                                System.out.println("Zadejte polomer.");
                                shapes.add(addCircle());
                                break;
                            //pridej square
                            case 2:
                                System.out.println("Zadejte delku strany a.");
                                shapes.add(addSquare());
                                break;
                            //pridej rectangle
                            case 3:
                                System.out.println("Zadejte delku stran a, b.");
                                shapes.add(addRectangle());
                                break;
                            default:
                                System.out.println("Volba neni ve vyberu!");
                                break;
                        }
                    }while(chooseShape != 0);
                    break;
                //vypis celkovou plochu
                case 2:
                    System.out.println(calculateArea(shapes));
                    break;
                //vypis objekty
                case 3:
                    printShapes(shapes);
                    break;
                default:
                    System.out.println("Volba neni ve vyberu!");
                    break;
            }
        }while(choice != 0);
    }
}
