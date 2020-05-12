package safarik_hurricane;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Main_Hurricane {
    public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HurricanesData hd = new HurricanesData();
        try {
            hd.load("hurricanedata.txt");
            int choice;
            do{
                System.out.println(getMenu());
                choice = sc.nextInt();
                switch(choice){
                    case 1:
                        System.out.print("Year minimum: ");
                        int minYear = sc.nextInt();
                        System.out.print("Year maximum: ");
                        int maxYear = sc.nextInt();
                        System.out.println(hd.getInfoThgroughYears(minYear, maxYear));
                        break;
                    case 2:
                        System.out.print("Enter name: ");
                        String name = sc.next();
                        try{
                            System.out.format("Category: %1d Speed: %3.2f\n", hd.findHurricaneByName(name).getCategory(), hd.findHurricaneByName(name).getSpeed());
                        } catch(NullPointerException n){
                            System.out.println("Such hurricane is not on the list.");
                        }
                        break;
                    case 3:
                        System.out.println(hd.getDataSortedBySpeed());
                        break;
                    case 0:
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Not a valid option.");
                        break;
                }
            }while(choice != 0);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main_Hurricane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Gives the options menu for user choice
     * @return String with possible choice options
     */
    private static String getMenu(){
        return "1: Print hurricanes between years\n"
                + "2: Find and print data about hurricane specified by name\n"
                + "3: Sort data by speed and print\n"
                + "0: Finish";
    }
    
}
