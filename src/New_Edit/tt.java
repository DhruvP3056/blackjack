/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New_Edit;

/**
 *
 * @author dhruv
 */
public class tt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand hn = new Hand(deck.getCards());
        hn.pl();
        hn.addUserCard();
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println();
        hn.addDealerCard();
        System.out.println();

        hn.pl();
    }

}
