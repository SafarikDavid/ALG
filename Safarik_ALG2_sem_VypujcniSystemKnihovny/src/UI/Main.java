package UI;

import App.BookInventory;
import App.ClientsList;
import java.util.Scanner;

/**
 *
 * @author David Šafařík
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //načti data ze souborů
        BookInventory bInv = new BookInventory();
        bInv.loadData("inventory.txt");
        ClientsList cList = new ClientsList();
        cList.loadData("clients.txt");
        //cyklus programu
        int choice, choiceInner;
        do{
            //vypiš menu
            System.out.println(getMainMenu());
            //načti volbu
            choice = sc.nextInt();
            //switch statement
            switch(choice){
                //BookInventory práce
                case 1:
                    do{
                        choiceInner = sc.nextInt();
                        switch(choiceInner){
                            //vypiš všechny knihy
                            case 1:
                                break;
                            //vypiš abecedně seřazené knihy
                            case 2:
                                break;
                            //vypiš volné knihy
                            case 3:
                                break;
                            //vypiš volné knihy abecedně seřazené
                            case 4:
                                break;
                            //najdi knihu podle názvu
                            case 5:
                                break;
                            //návrat
                            case 0:
                                break;
                            default:
                                break;
                        }
                        break;
                    }while(choiceInner != 0);
                    break;
                //client práce
                case 2:
                    do{
                        choiceInner = sc.nextInt();
                        switch(choiceInner){
                            //registruj klienta 
                            case 1:
                                break;
                            //vypiš registrované klienty
                            case 2:
                                break;
                            //najdi klienta podle ID a vypiš vypůjčené knihy
                            case 3:
                                break;
                            //návrat
                            case 0:
                                break;
                            default:
                                break;
                        }
                        break;
                    }while(choiceInner != 0);
                    break;
                //výpůjčky
                case 3:
                    do{
                        choiceInner = sc.nextInt();
                        switch(choiceInner){
                            //vypůjčit knihu
                            case 1:
                                break;
                            //vrátit knihu
                            case 2:
                                break;
                            //návrat
                            case 0:
                                break;
                            default:
                                break;
                        }
                        break;
                    }while(choiceInner != 0);
                    break;
                //ukoncit
                case 0:
                    break;
                default:
                    break;
            }
        }while(choice != 0);
    }

    private static boolean getMainMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
