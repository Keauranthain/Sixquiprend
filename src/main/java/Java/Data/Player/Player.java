package Java.Data.Player;

import Java.Data.Card.Card;
import Java.Data.Card.Deck;
import Java.Data.Game;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter
public abstract class Player {
    Card[] hand;
    int point;
    String name;
    public void play(){
        Card card = throw_card();
        Game.throwcard.add(card);
    }
    public abstract int choose_card();
    public abstract int choose_stack();
    private Card throw_card(){
        int card = choose_card();
        Card thecard = hand[card];
        thecard.setMyplayer(this);
        hand[card]=null;
        return thecard;
    }
    public void draw(){
        hand = new Card[10];
        for (int k=0;k<10;k++){
            hand[k]=Game.mydeck.getcard(0);
            Game.mydeck.remove(0);
        }

    }
}
