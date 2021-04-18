/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.view;

import blackjack.model.Card;
import blackjack.model.Deck;
import blackjack.model.HandValueCalculator;
import blackjack.model.Value;

/**
 *
 * @author dhruvpatel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Deck test = new Deck();
        Deck test1 = new Deck();

        HandValueCalculator valueCalculator = HandValueCalculator.getInstance();

        test.createDeck();
        test.shuffle();
        test1.draw(test);
        test1.draw(test);
        test1.draw(test);
        System.out.println(test1.toString());
        
        valueCalculator.cardsValue(test1.getCards());
        
        for (Card test3 : test1.getCards()) {
            if (test3.getValue() == Value.JOKER) {
                System.out.println(valueCalculator.getValOfJoker());
            }

        }
//        valueCalculator.cardsValue(test1.getCards());
        if (test1.getCard(0).getValue() == Value.JOKER || test1.getCard(1).getValue() == Value.JOKER) {
            System.out.println(valueCalculator.getValOfJoker());
        }

    }

}
