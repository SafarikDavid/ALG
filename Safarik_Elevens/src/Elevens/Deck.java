package Elevens;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author David Šafařík
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck(String[] symbols, String[] values, int[] points){
        for(String s : symbols){
            for(int i = 0; i < values.length; i++){
                deck.add(new Card(s, values[i], points[i]));
            }
        }
    }

    public int getSizeOfDeck(){
        return deck.size();
    }
    
    public Card deal(){ 
        Card card = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return card;
    }
    
    public void shuffle(){
        Collections.shuffle(deck);
    }
    
//    public Deck(String symbol, String value, int numberOfPoints){
//        deck.add(new Card(symbol, value, numberOfPoints));
//    }
//    public Deck(Card card){
//        deck.add(card);
//    }
//    
//    public Deck() {
//        this.deck.addAll(makeFullDeck());
//    }
//    private ArrayList<Card> makeCardsOfOneColor(String symbol){
//        ArrayList<Card> newDeck = new ArrayList<>();
//        newDeck.add(new Card(symbol,"A",1));
//        for(int i = 2; i <= 10; i++){
//            newDeck.add(new Card(symbol,Integer.toString(i),i));
//        }
//        newDeck.add(new Card(symbol,"J",0));
//        newDeck.add(new Card(symbol,"Q",0));
//        newDeck.add(new Card(symbol,"K",0));
//        return newDeck;
//    }
//    
//    private ArrayList<Card> makeFullDeck(String[] symbols){
//        ArrayList<Card> newDeck = new ArrayList<>();
//        for(String s : symbols){
//            newDeck.addAll(makeCardsOfOneColor(s));
//        }
//        return newDeck;
//    }
}
