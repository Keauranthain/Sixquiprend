package Java.Data.Player;

import Java.Data.Card.Card;
import Java.Data.Card.Stack;
import Java.Data.Game;

import java.util.List;

public class AIplayer extends Player {
    public AIplayer (String name){
        this.name =name;
    }
    public int choose_card(){
        int result = -1;
        int mini = 105;
        int maxi = 0;
        int themax = 0;
        for (int k = 0;4>k;k++){
            Stack stack = Game.mysacks.get(k);
            if (stack.getMystack().get(stack.size()-1).getNumber()<mini && stack.size()<5){
                mini = stack.getMystack().get(stack.size()-1).getNumber();
            }
        }
        for (int k=1;hand.length>k;k++){
            if (result == -1 && hand[k].getNumber()>mini){
                result = k;
            } else if(result > -1) {
                if (hand[k].getNumber()<hand[result].getNumber() && hand[k].getNumber()>mini){
                    result = k;
                }
            }
            if(hand[k].getNumber()>themax){
                themax = hand[k].getNumber();
                maxi = k;
            }
        }
        if (result == -1){
            result = maxi;
        }
        return result;
    }

    public int choose_stack() {
        int result = 0;
        int mini = Game.mysacks.get(0).point();
        for (int k=1;k<4;k++){
            if (Game.mysacks.get(k).point()<mini){
                mini=Game.mysacks.get(k).point();
                result = k;
            }
        }
        return result;
    }
}
