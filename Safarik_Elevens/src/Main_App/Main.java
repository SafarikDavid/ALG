package Main_App;
import Elevens.*;
import java.util.Scanner;

/**
 *
 * @author David Šafařík
 */
public class Main {

    static Scanner sc = new Scanner(System.in);
    
    private final static String[] SYMBOLS = {"spades", "diamonds", "hearts", "clubs"};
    private final static String[] VALUES = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private final static int[] POINTS = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private final static int SIZE = 11;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printInstructions();
        Game game = new Game(SYMBOLS, VALUES, POINTS, SIZE);
        int[] replace = new int[2];
        while(game.isPlayingPossible()){
            System.out.println("");
            System.out.println("New set:");
            System.out.println(game.toString());
            System.out.println("Choose two cards to exchange.");
            replace[0] = sc.nextInt() - 1;
            replace[1] = sc.nextInt() - 1;
            System.out.println(((game.replaceSelectedCards(replace))?("Valid"):("Invalid")) + " choice.");
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("\nFinal hand:");
        System.out.println(game.toString());
        System.out.println("Game over!");
    }
    
    private static void printInstructions(){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Welcome to eleven card game.");
        System.out.println("The goal of the game is to choose two cards among 11 at hand.");
        System.out.println("The two chosen cards must give a total value of 11.");
        System.out.println("The game ends when there are no more possible combinations.");
        System.out.println("-------------------------------------------------------------");
    }
    
}
