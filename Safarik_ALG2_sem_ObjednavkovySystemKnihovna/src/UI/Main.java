package UI;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //načti data ze souborů
        OrdersPending op = new OrdersPending();
        op.loadData("ordersPending.txt");
        OrdersSettled os = new OrdersSettled();
        os.loadData("ordersSettled.txt");
        //cyklus programu
        int choice;
        do{
            //vypiš menu
            System.out.println(getMainMenu());
            //načti volbu
            choice = sc.nextInt();
            //switch statement
            switch(choice){
                case 0:
                    break;
            }
        }while(choice != 0);
    }

    private static boolean getMainMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
