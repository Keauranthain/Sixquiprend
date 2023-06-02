package Java.Data.Printer;

import Java.Data.Card.Card;
import Java.Data.Card.Stack;

public class Stacker {
    public String card1;
    public String card2;
    public String card3;
    public String card4;
    public String card5;
    public Stacker(){}
    public void stackerdefine(Stack stack){
        switch (stack.size()){
            case 5:
                card5 = stack.getMystack().get(4).getImage();
            case 4:
                card4 = stack.getMystack().get(3).getImage();
            case 3:
                card3 = stack.getMystack().get(2).getImage();
            case 2:
                card2 = stack.getMystack().get(1).getImage();
            case 1:
                card1 = stack.getMystack().get(0).getImage();
            default:
                break;
        }





    }
}
