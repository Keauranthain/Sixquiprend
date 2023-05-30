package Java.Data.Player;

import Java.Data.Card.Card;

import java.util.Scanner;

public class Realplayer extends Player{
    public Realplayer (String name){
        this.name =name;
    }
    public int choose_card(){
        for (int k = 0; k<hand.length;k++){
            System.out.print(hand.length);
            System.out.print(" ");
        }
        System.out.println("");
        System.out.print("Quelle carte : ");
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        return input;
    }
    public int choose_stack(){
        System.out.print("Quelle stack : ");
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        return input;
    }

}
