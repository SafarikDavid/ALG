package Elevens;

import java.util.regex.*;

/**
 *
 * @author David Šafařík
 */
public class Card {
    private String symbol;
    private String value;
    private int numberOfPoints;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
        this.numberOfPoints = calculatePoints(value);
    }
    
    public Card(String symbol, String value, int numberOfPoints) {
        this.symbol = symbol;
        this.value = value;
        this.numberOfPoints = numberOfPoints;
    }

    private static int calculatePoints(String value){
        if( value.matches("[2-9]|10") ){
            return Integer.parseInt(value);
        }else if(value.matches("[aA]|[aA][cC][eE]")){
            return 1;
        }else return 0;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    @Override
    public String toString() {
        return "Card{ " + "value= " + value + ", symbol= " + symbol + " }";
    }
    
    
    
    public static void main(String[] args){
        Card karta = new Card("hearts","4");
        System.out.println(karta.getNumberOfPoints());
    }
}
