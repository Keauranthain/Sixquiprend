package Java.Data;

import Java.Data.Card.Card;
import Java.Data.Card.Deck;
import Java.Data.Card.Stack;
import Java.Data.Player.AIplayer;
import Java.Data.Player.Player;
import Java.Data.Player.Realplayer;
import Java.Data.Printer.Printer;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static Deck mydeck;
    public static List<Stack> mysacks;
    public static Deck throwcard;
    public static Printer printer;
    List<Player> myplayers;
    public Game (int real,int ai){
        Deck deck = new Deck();
        List<Stack> stacks = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        deck.centraldeckmaker();
        for (int k = 0 ; k<4;k++) {
            stacks.add(new Stack(deck));
        }
        for (int k = 0 ; k<real;k++) {
            players.add(new Realplayer("Player "+k));
        }
        for (int k = 0 ; k<ai;k++) {
            players.add(new AIplayer("AI "+k));
        }
        this.mydeck=deck;
        this.mysacks=stacks;
        this.myplayers=players;
        this.throwcard=new Deck();
        this.printer = new Printer();
    }

    public void play (){
        gamestart();
        for (int n_turn=1;n_turn<11;n_turn++){
            turn();
        }
        gameresult();
    }
    private void gamestart (){
        for (int k=0;myplayers.size()>k;k++){
            myplayers.get(k).draw();
        }
    }
    private void gameresult(){
        ranking();
        for (int k=0;k<myplayers.size();k++){
            System.out.print(k+1);
            System.out.print(" : ");
            System.out.print(myplayers.get(k).getName());
            System.out.print("   Score :");
            System.out.println(myplayers.get(k).getPoint());
        }
    }
    private void turn(){
        for (int k = 0; k<4; k++){
            System.out.print(mysacks.get(k).getMystack().get(0).getNumber());
            for (int i = 1; i<mysacks.get(k).size(); i++){
                System.out.print(", ");
                System.out.print(mysacks.get(k).getMystack().get(i).getNumber());
            }
            System.out.println(".");
        }
        for (int k=0;myplayers.size()>k;k++){
            myplayers.get(k).play();
        }
        for (int k = 0 ; myplayers.size()>k;k++){
            System.out.print(myplayers.get(k).getName());
            System.out.print(" : ");
            System.out.println(throwcard.get(k));
        }
        place();
    }
    private void place(){
        throwcard.merge();
        while (throwcard.size()>0) {
            int closer = -1;
            Card playercard = throwcard.getcard(0);
            int playercardnumber = playercard.getNumber();
            for (int i = 0; i < 4; i++) {
                int stackcard = mysacks.get(i).last();
                if (stackcard < playercardnumber && (closer == -1 || stackcard > mysacks.get(closer).last())) {
                    closer = i;
                }
            }
            if (closer == -1) {
                Player player = throwcard.getplayer(0);
                int stack = player.choose_stack();
                System.out.print(player.getName());
                System.out.print(" à récuperer le tas ");
                System.out.print(stack + 1);
                System.out.print(" valant ");
                System.out.print(mysacks.get(stack).point());
                System.out.println(" point.");
                player.setPoint(player.getPoint() + mysacks.get(stack).point());
                mysacks.remove(stack);
                mysacks.add(new Stack(throwcard));
            }else if (mysacks.get(closer).control()) {
                Player player = throwcard.getplayer(0);
                System.out.print(player.getName());
                System.out.print(" à récuperer le tas ");
                System.out.print(closer + 1);
                System.out.print(" valant ");
                System.out.print(mysacks.get(closer).point());
                System.out.println(" point.");
                player.setPoint(player.getPoint() + mysacks.get(closer).point());
                mysacks.remove(closer);
                mysacks.add(new Stack(throwcard));
            }else {
                mysacks.get(closer).add(playercard);
                throwcard.remove(0);
            }
        }
    }
    private void ranking(){
        myplayers = mergeA(myplayers);
    }
    private List<Player> mergeA(List<Player> players){
        List<Player> playersfinal;
        if (players.size()>1){
            int cut = players.size()/2;
            List<Player> playersA = new ArrayList<>(players.subList(0, cut));
            List<Player> playersB =new ArrayList<>(players.subList(cut, players.size()));
            playersfinal = mergeB(mergeA(playersA),mergeA(playersB));
        } else {
            playersfinal = new ArrayList<>(players);
        }
        return playersfinal;
    }
    private List<Player> mergeB(List<Player> playersA,List<Player> playersB){
        List<Player> playersfinal = new ArrayList<>();
        while (!playersA.isEmpty() && !playersB.isEmpty()){
            if(playersA.get(0).getPoint()>playersB.get(0).getPoint()){
                playersfinal.add(playersB.get(0));
                playersB.remove(0);
            }
            else {
                playersfinal.add(playersA.get(0));
                playersA.remove(0);
            }
        }
        playersfinal.addAll(playersA);
        playersfinal.addAll(playersB);
        return playersfinal;
    }


}
