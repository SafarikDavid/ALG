package interfaceVariant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author David Šafařík
 */
public class ShapesApp {
    //udelat novou metodu pro sort objektu, ale stahnout si od ni code
    
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<ShapeInterface> shapes = new ArrayList<>();
    
    public static void main(String[] args){
        System.out.println("Welcome to the Shapes app.");
        //variable declaration
        int choice;
        int chooseShape;
        //app cycle
        do{
            //print main menu
            printMenu();
            switch (choice = readChoice()){
                //exit
                case 0:
                    System.out.println("Exiting...");
                    break;
                //new set
                case 1:
                    System.out.println("Deleting all objects...");
                    clearObjects();
                    break;
                //add shapes
                case 2:
                    do{
                        //print addShapeMenu
                        printAddShapeMenu();
                        switch (chooseShape = readChoice()){
                            //return
                            case 0:
                                System.out.println("Returning to main menu.");
                                break;
                            //add circle
                            case 1:
                                System.out.println("Enter radius.");
                                shapes.add(addCircle());
                                break;
                            //add square
                            case 2:
                                System.out.println("Enter a.");
                                shapes.add(addSquare());
                                break;
                            //add rectangle
                            case 3:
                                System.out.println("Enter a and b.");
                                shapes.add(addRectangle());
                                break;
                            default:
                                System.out.println("Choice not supported.");
                                break;
                        }
                    }while(chooseShape != 0);
                    break;
                //display objects
                case 3:
                    printShapes();
                    break;
                //display area total
                case 4:
                    System.out.println("Area total:");
                    System.out.println(computeArea());
                    break;
                //display biggest shape
                case 5:
                    System.out.println("Printing shape with max area:");
                    System.out.println(shapes.get(findWithMaxArea()).toString());
                    break;
                //display area of chosen shape
                case 6:
                    getObjectInfo();
                    break;
                //sort by area
                case 7:
                    System.out.println("Shapes, sorted:");
                    sortByArea();
                    printShapes();
                    break;
                default:
                    System.out.println("Choice not in the menu!");
                    break;
            }
        }while(choice != 0);
    }
    
    private static void printMenu(){
        System.out.println("\n"
                + "-------------------\n"
                + "Main menu\n"
                + "1: new set\n"
                + "2: add shapes\n"
                + "3: print out shapes\n"
                + "4: calculate total area\n"
                + "5: print biggest shape\n"
                + "6: print area of chosen shape\n"
                + "7: sort by area\n"
                + "0: exit app\n"
                + "-------------------\n");
    }
    
    private static void printAddShapeMenu(){
        System.out.println("\n"
                + "-------------------\n"
                + "Add shape menu\n"
                + "1: circle\n"
                + "2: square\n"
                + "3: rectangle\n"
                + "0: return to main menu\n"
                + "-------------------\n");
    }
    
    /**
     * Reads input and checks whether is Int or not
     * @return -1 if not Int, else input
     */
    private static int readChoice() {
        String number;
        int choice = -1;
        number = sc.next();
        try{
            choice = Integer.parseInt(number);
        }catch (NumberFormatException ex){
            System.out.println("Invalid input, try again!");
        }
        return choice;
    }
    
    /**
     * Creates a circle shape
     * @return Circle instance
     */
    private static Circle addCircle(){
        double r = sc.nextDouble();
        return new Circle(r);
    }
    
    /**
     * Creates a square object
     * @return Square instance
     */
    private static Square addSquare(){
        double a = sc.nextDouble();
        return new Square(a);
    }
    
    /**
     * Creates a rectangle shape
     * @return Rectangle instance
     */
    private static Rectangle addRectangle(){
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        return new Rectangle(a, b);
    }
    
    /**
     * Computes the total area of the set of shapes
     * @return Computed area
     */
    private static double computeArea(){
        double area = 0;
        for(ShapeInterface s : shapes){
            area += s.computeArea();
        }
        return area;
    }
    
    /**
     * Display all shapes
     */
    private static void printShapes(){
        for(ShapeInterface s : shapes){
            System.out.println(s.toString());
        }
    }

    /**
     * Clears up the ArrayList
     */
    private static void clearObjects() {
        shapes.clear();
    }

    /**
     * Finds the shape with max area
     * @return index of the shape
     */
    private static int findWithMaxArea() {
        double max = -Double.MAX_VALUE;
        int maxIndex = 0;
        for(int i = 0; i < shapes.size(); i++){
            if(shapes.get(i).getArea() > max){
                max = shapes.get(i).getArea();
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static void getObjectInfo() {
        int i = 1;
        for(ShapeInterface s : shapes){
            System.out.println(i + ": " + s.toString());
            i++;
        }
        int choice;
        do{
            choice = readChoice();
        }while(choice < 0 && choice >= shapes.size());
        System.out.println(shapes.get(choice-1).getShapeName() + " Area = " + shapes.get(choice-1).getArea());
    }

    /**
     * Sorts the ArrayList<ShapeInterface>
     */
    private static void sortByArea() {
        shapes.sort(Comparator.comparing((name) -> name.getArea()));
    }
}