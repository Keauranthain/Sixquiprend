package Java.Data.Player;

import Java.Data.Card.Card;
import Java.Data.Card.Deck;
import Java.Data.Card.Stack;
import Java.Data.Game;

import java.util.List;
public class Realplayer extends Player{
    public Realplayer (String name){
        this.name =name;
    }
    public void play(List<Stack> stacks, Deck throwcard){
        if (Game.user!=-1){
            Card card = throw_card(Game.user,stacks);
            throwcard.add(card);
        }
    }

    public void choose_stack(List<Stack> stacks, Deck throcard){
        int result = 1;
        if (Game.user!=-1){
            result = Game.user;
            addpoint(stacks.get(result),throcard);
        }
        System.out.println("valeur :"+Game.user);
    }

}
