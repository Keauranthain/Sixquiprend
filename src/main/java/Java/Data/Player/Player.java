package Java.Data.Player;

import Java.Data.Card.Card;
import Java.Data.Card.Deck;
import Java.Data.Card.Stack;
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
    public abstract void play(List<Stack> stacks,Deck throwcard);
    public abstract void choose_stack (List<Stack> stacks,Deck throcard);
    public void draw(Deck deck){
        hand = new Card[10];
        for (int k=0;k<10;k++){
            hand[k]=deck.getcard(0);
            deck.remove(0);
        }

    }
    public Card throw_card(int card, List<Stack> stacks){
        Card thecard = hand[card];
        thecard.setMyplayer(this);
        hand[card]=null;
        return thecard;
    }
    public void addpoint(Stack stacks,Deck throwcard){
        point = point + stacks.point();
        stacks.reset(throwcard.getcard(0));
        throwcard.remove(0);
    }
}
