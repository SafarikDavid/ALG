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
        Calendar cal = newCalendarInput();
        int choice;
        do{
            printMenu();
            choice = sc.nextInt();
            switch(choice){
                //display calendar
                case 1:
                    System.out.println("");
                    System.out.println(cal.displayCalendar());
                    System.out.println("");
                    break;
                //change day
                case 2:
                    printChangeDayMenu();
                    changeDay(cal, sc.nextInt());
                    break;
                //change month
                case 3:
                    printChangeMonthMenu();
                    changeMonth(cal, sc.nextInt());
                    break;
                //change year
                case 4:
                    printChangeYearMenu();
                    changeYear(cal, sc.nextInt());
                    break;
                //reset calendar
                case 5: 
                    cal = newCalendarInput();
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
    
    private static void printChangeDayMenu(){
        System.out.println("1: One day forward\n"
                + "2: One day back\n"
                + "Other: Go back to main menu");
    }
    
    private static void changeDay(Calendar cal, int choice){
        switch(choice){
            //forward 1
            case 1:
                cal.nextDay();
                break;
            //1 back
            case 2:
                cal.previousDay();
                break;
            default:
                break;
        }
    }
    private static void printChangeMonthMenu(){
        System.out.println("1: One month forward\n"
                + "2: One month back\n"
                + "Other: Go back to main menu");
    }
    
    private static void changeMonth(Calendar cal, int choice){
        switch(choice){
            //forward 1
            case 1:
                cal.nextMonth();
                break;
            //1 back
            case 2:
                cal.previousMonth();
                break;
            default:
                break;
        }
    }
    private static void printChangeYearMenu(){
        System.out.println("1: One year forward\n"
                + "2: One year back\n"
                + "Other: Go back to main menu");
    }
    
    private static void changeYear(Calendar cal, int choice){
        switch(choice){
            //forward 1
            case 1:
                cal.nextYear();
                break;
            //1 back
            case 2:
                cal.previousYear();
                break;
            default:
                break;
        }
    }
    
    private static Calendar newCalendarInput(){
        int[] values = new int[3];
        System.out.print("Day: ");
        values[0] = Math.abs(sc.nextInt());
        System.out.print("Month: ");
        values[1] = Math.abs(sc.nextInt());
        System.out.print("Year: ");
        values[2] = sc.nextInt();
        return new Calendar(values[0],values[1],values[2]);
    }
    
    private static void printMenu(){
        System.out.println("1: Display calendar\n"
                + "2: Change day\n"
                + "3: Change month\n"
                + "4: Change year\n"
                + "5: Reset calendar and enter new values\n"
                + "0: Exit app");
    }
}
