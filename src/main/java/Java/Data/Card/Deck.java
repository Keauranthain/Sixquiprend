package Java.Data.Card;

import Java.Data.Player.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter @Setter
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
    }
    public void draw(int number,Deck deck){
        for (int k=0;k<number;k++){
            mydeck.add(deck.mydeck.get(0));
            deck.mydeck.remove(0);
        }
    }
    public void merge(){
        mydeck = mergeCardsA(mydeck);
    }
    private List<Card> mergeCardsA(List<Card> cards){
        List<Card> cardsfinal;
        if (cards.size()>1){
            int cut = cards.size()/2;
            List<Card> cardsA = new ArrayList<>(cards.subList(0, cut));
            List<Card> cardsB =new ArrayList<>(cards.subList(cut, cards.size()));
            cardsfinal = mergeCardsB(mergeCardsA(cardsA),mergeCardsA(cardsB));
        } else {
            cardsfinal = new ArrayList<>(cards);
        }
        return cardsfinal;
    }
    private List<Card> mergeCardsB(List<Card> cardsA, List<Card>cardsB){
        List<Card> cardsfinal = new ArrayList<>();
        while (!cardsA.isEmpty() && !cardsB.isEmpty()){
            if(cardsA.get(0).getNumber()>cardsB.get(0).getNumber()){
                cardsfinal.add(cardsB.get(0));
                cardsB.remove(0);
            }
            else {
                cardsfinal.add(cardsA.get(0));
                cardsA.remove(0);
            }
        }
        cardsfinal.addAll(cardsA);
        cardsfinal.addAll(cardsB);
        return cardsfinal;
    }
    public void add(Card card){
        mydeck.add(card);
    }
    public void clear(){
        mydeck = new ArrayList<>();
    }
    public int size(){
        return mydeck.size();
    }
    public int get(int n){
        return mydeck.get(n).getNumber();
    }
    public Card getcard(int n){
        return mydeck.get(n);
    }
    public Player getplayer(int n){
        return mydeck.get(n).getMyplayer();
    }
    public void remove(int n){
        mydeck.remove(n);
    }
}
