package safarik_kalendar;

import java.util.Scanner;

/**
 *
 * @author David Šafařík
 */
public class MainApp {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to the calender app.");
        System.out.println("Enter your date. Day, Month and Year.");
        Calendar cal = new Calendar(sc.nextInt(), sc.nextInt(), sc.nextInt());
        int choice;
        do{
            printMenu();
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("");
                    System.out.println(cal.displayCalendar());
                    System.out.println("");
                    break;
                case 2:
                    cal.nextMonth();
                    break;
                case 3:
                    cal.previousMonth();
                    break;
                case 4:
                    cal = new Calendar(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;
                case 0:
                    System.out.println("Exiting app.");
                    break;
                default:
                    System.out.println("Option not supported!");
                    break;
            }
        }while(choice != 0);
        
    }
    
    private static void printMenu(){
        System.out.println("1: Display calendar\n"
                + "2: Change to next month\n"
                + "3: Change to previous month\n"
                + "4: Reset calendar and enter new values\n"
                + "0: Exit app");
    }
}
