/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevens;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Šafařík
 */
public class Game {
    private Deck deck;
    private Card[] cardsInPlay;
    
    public Game(String[] symbols, String[] values, int[] points, int size){
        deck = new Deck(symbols, values, points);
        deck.shuffle();
        cardsInPlay = new Card[size];
        init();
    }
    
    public void init(){
        for(int i = 0; i < cardsInPlay.length; i++){
            cardsInPlay[i] = deck.deal();
        }
    }
    
    public boolean replaceSelectedCards(int[] selection){
        if(isValid(selection)){
            cardsInPlay[selection[0]] = deck.deal();
            cardsInPlay[selection[1]] = deck.deal();
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isValid(int[] sel){
        boolean deckSize = deck.getSizeOfDeck() > 1;
        boolean inUpperLimits = sel[0] < cardsInPlay.length && sel[1] < cardsInPlay.length;
        boolean inLowerLimits = sel[0] >= 0 && sel[1] >= 0;
        boolean inLimits = inLowerLimits && inUpperLimits;
        boolean cardsDiffer;
        boolean isEleven;
        if(inLimits){
            isEleven = cardsInPlay[sel[0]].getNumberOfPoints() + cardsInPlay[sel[1]].getNumberOfPoints() == 11;
            cardsDiffer = cardsInPlay[sel[0]] != cardsInPlay[sel[1]];
        }else{
            return false;
        }
        return deckSize && isEleven && cardsDiffer && inLimits;
    }
    
    public boolean isPlayingPossible(){
        for(int i = 0; i < cardsInPlay.length - 1; i++){
            for(int j = i + 1; j < cardsInPlay.length; j++){
                if(cardsInPlay[i].getNumberOfPoints() + cardsInPlay[j].getNumberOfPoints() == 11){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= cardsInPlay.length; i++){
            sb.append(i).append(". ").append(cardsInPlay[i-1].toString()).append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
        String[] symbols = {"spades", "diamonds", "hearts", "clubs"};
        String[] values = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int[] points = {1,2,3,4,5,6,7,8,9,10,0,0,0};
        int size = 11;
        Game game = new Game(symbols, values, points, size);
        System.out.println(game.deck.getSizeOfDeck());
        System.out.println(game.toString());
        System.out.println(game);
        System.out.println(game.deck.getSizeOfDeck());
    }
}
