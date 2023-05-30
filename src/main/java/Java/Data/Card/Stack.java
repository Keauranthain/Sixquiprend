package Java.Data.Card;

import Java.Data.Card.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter
public class Stack {
    List<Card> mystack;

    public Stack (Card card){
        List<Card> stack = new ArrayList<>();
        stack.add(card);
        this.mystack = stack;
    }
    public Stack (Deck card){
        List<Card> stack = new ArrayList<>();
        stack.add(card.getMydeck().get(0));
        card.getMydeck().remove(0);
        this.mystack = stack;
    }

    public boolean control(){
        boolean result = false;
        if (size()==5){
            result = true;
        }
        return result;
    }
    public int point (){
        int result = 0;
        for (int k = 0; k<mystack.size();k++){
            result += mystack.get(k).getBullhead();
        }
        return result;
    }

    public int size(){
        return mystack.size();
    }
    public int last(){
        return mystack.get(mystack.size()-1).getNumber();
    }
    public void add(Card card){
        mystack.add(card);
    }
}
