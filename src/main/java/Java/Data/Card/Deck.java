package Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    List<Card> mydeck ;

    public Deck () {
        this.mydeck = new ArrayList<Card>();
    }

    public void centraldeckmaker(){
        int melange = 10000;
        for (int k = 1; k < 105;k++) {
            mydeck.add(new Card(k));
        }
        for (int k = 0; k < melange;k++) {
            Random random = new Random();

            List<Card> mynewdeck= new ArrayList<Card>();
            while (mydeck.size()>0){
                int card = random.nextInt(mydeck.size());
                mynewdeck.add(mydeck.get(card));
                mydeck.remove(card);
            }
            mydeck = new ArrayList<>();
            mydeck.addAll(mynewdeck);
        }
        for (int k = 0; mydeck.size()>k;k++) {
            System.out.println(mydeck.get(k).getNumber());
        }
    }
    public void draw(int number,Deck deck){
        for (int k=0;k<number;k++){
            mydeck.add(deck.mydeck.get(0));
            deck.mydeck.remove(0);
        }
    }
}
